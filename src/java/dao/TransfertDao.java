/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.ConnectionDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Transfert;
import java.util.Date;

/**
 *
 * @author Perfectus
 */
public class TransfertDao implements IDao<Transfert> {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public int saveT(Transfert transfert, String id) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        if (connection != null) {
                //creation la chaine de requete
            if(!transfert.getEtat().equalsIgnoreCase("N")){
                String requete = "INSERT INTO Transfert (idVehicule, idExProprietaire, idNewProprietaire, motifTransfert, dateTransfert, etat) VALUES (?, ?, ?, ?, ?, ?)";

                // Utilisation de la methode preparedStatement
                pst = connection.prepareStatement(requete);
                // passage des parametres a la requete
                pst.setString(1, transfert.getIdVehicule());
                pst.setString(2, transfert.getIdExProprietaire());
                pst.setString(3, id);
                pst.setString(4, transfert.getMotifTransfert());
                if(!transfert.getEtat().equalsIgnoreCase("A")){
                    Date currentDate = new Date();
                    // Convertir en java.sql.Date
                   Date sqlDate = new Date(currentDate.getTime());  
                   pst.setDate(5, new java.sql.Date(sqlDate.getTime()) );
                }else{
                    pst.setDate(5, null);
                }
                if (transfert.getEtat() != null) {
                    pst.setString(6, transfert.getEtat());
                }else{
                    pst.setString(6, "E");
                }

                // execution la requete
                int n = pst.executeUpdate();

                // fermer les connections
                ConnectionDB.closeConnection(rs, pst, connection);

                return n;       
            }
        }
        return 0;
    }

    @Override
    public int update(Transfert transfert) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            if(transfert.getEtat().equalsIgnoreCase("A")){
                //creation la chaine de requete
                String requete="UPDATE Transfert SET dateTransfert=?, etat=? WHERE id=?";

                // Utilisation de la methode preparedStatement
                pst=connection.prepareStatement(requete);

                // passage des parametres a la requete
                //pst.setString(1, vehicule.genererCode());
                Date currentDate = new java.util.Date();
                // Convertir en java.sql.Date
                Date sqlDate = new Date(currentDate.getTime());  
                pst.setDate(1, new java.sql.Date(sqlDate.getTime()));
                pst.setString(2, transfert.getEtat());
                pst.setInt(3, transfert.getId());
                // execution la requete
                int n = pst.executeUpdate();

                // fermer les connections
                ConnectionDB.closeConnection(rs, pst, connection);

                return n;
            }
        }
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        //creation la chaine de requete
        String requete="DELETE FROM Transfert WHERE id=?";

        // Utilisation de la methode preparedStatement
        pst=connection.prepareStatement(requete);

        // passage des parametres a la requete
        pst.setInt(1, Integer.parseInt(id));
        // execution la requete
        int n = pst.executeUpdate();

        // fermer les connections
        ConnectionDB.closeConnection(rs, pst, connection);

        return n;
    }

    @Override
    public List<Transfert> getAll() throws SQLException, ClassNotFoundException {
        // creer une liste generique
        List<Transfert> listTransfert = new ArrayList<>();
        // recuperation de la connexion a la BD
        connection = ConnectionDB.getConnection();
        // creer la chaine de requete
        String requete = "SELECT * FROM Transfert";
        // appelle a la methode preparedStatement
        pst = connection.prepareStatement(requete);
        // executer la requete en stockant le resultat dans un ResultSet
        rs = pst.executeQuery();

        // parcourrir le ResultSet
        Transfert model = null;
        while (rs.next()) {
            model = new Transfert();
            model.setId(Integer.parseInt(rs.getString("id")));
            model.setIdVehicule(rs.getString("idVehicule"));
            model.setIdExProprietaire(rs.getString("idExProprietaire"));
            model.setIdNewProprietaire(rs.getString("idNewProprietaire"));
            model.setMotifTransfert(rs.getString("motifTransfert"));
            model.setDateTransfert(rs.getDate("dateTransfert"));
            model.setEtat(rs.getString("etat"));

            // ajouter les objets dans la collection
            listTransfert.add(model);
        }
        ConnectionDB.closeConnection(rs, pst, connection);
        return listTransfert;
    }

    @Override
    public Transfert get(String id) throws SQLException, ClassNotFoundException {
        // Connection a la base de donnee
        connection = ConnectionDB.getConnection();
        
        //Requete
        String req = "SELECT * FROM transfert WHERE id = ?";
        
        //Passage de la requete a la methode preparedStatement
        pst = connection.prepareStatement(req);
        //Passage du parametre a la methode
        pst.setString(1, id);
        
        Transfert model = new Transfert();//Creation d'une instance de vehicule

        //execution de la requete
        rs = pst.executeQuery();
        while(rs.next()){
           model.setId(Integer.parseInt(rs.getString("id")));
           model.setIdVehicule(rs.getString("idVehicule"));
           model.setIdExProprietaire(rs.getString("idExProprietaire"));
           model.setIdNewProprietaire(rs.getString("idNewProprietaire"));
           model.setMotifTransfert(rs.getString("motifTransfert"));
           model.setDateTransfert(rs.getDate("dateTransfert"));
           model.setEtat(rs.getString("ETAT"));
        }
        return model;
    }

    @Override
    public int save(Transfert obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
