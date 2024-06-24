/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Proprietaire;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 *
 * @author Perfectus
 */
public class ProprietaireDao implements IDao<Proprietaire> {
    Connection connection=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

 
    public String saveP(Proprietaire proprietaire) throws SQLException, ClassNotFoundException {
        int n = 0;
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        String id = proprietaire.genererCode();
        if(connection != null){
            try{
                //creation la chaine de requete
                String requete="INSERT INTO proprietaire (id, nom, prenom, sexe, telephone, adresse, typePiece, noPiece, courriel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                System.out.println("------------------");
                // Utilisation de la methode preparedStatement
                pst=connection.prepareStatement(requete);

                // passage des parametres a la requete
                pst.setString(1, id);
                pst.setString(2, proprietaire.getNom());
                pst.setString(3, proprietaire.getPrenom());
                pst.setString(4, proprietaire.getSexe());
                pst.setString(5, proprietaire.getTel());
                pst.setString(6, proprietaire.getAdresse());
                pst.setString(7, proprietaire.getTypePiece());
                pst.setString(8, proprietaire.getNoPiece());
                pst.setString(9, proprietaire.getCourriel());
                // execution la requete
                n = pst.executeUpdate();

                // fermer les connections
                ConnectionDB.closeConnection(rs, pst, connection);
            }catch(SQLIntegrityConstraintViolationException e){
                System.out.println("erreur -> "+e.getMessage());
            }
            if(n > 0){
                return id;
            }
        }   
        return null;
    }

    @Override
    public int update(Proprietaire proprietaire) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="UPDATE Proprietaire SET nom=?, prenom=?, sexe=?, telephone=?, adresse=?, typePiece=?, noPiece=?, courriel=? WHERE id=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);

            // passage des parametres a la requete
            pst.setString(1, proprietaire.getNom());
            pst.setString(2, proprietaire.getPrenom());
            pst.setString(3, proprietaire.getSexe());
            pst.setString(4, proprietaire.getTel());
            pst.setString(5, proprietaire.getAdresse());
            pst.setString(6, proprietaire.getTypePiece());
            pst.setString(7, proprietaire.getNoPiece());
            pst.setString(8, proprietaire.getCourriel());
            pst.setString(9, proprietaire.getId());
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }    
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprietaire> getAll() throws SQLException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
              // creer une liste generique
      List<Proprietaire> listProprietaire=new ArrayList<>();
        // recuperation de la connexion a la BD
        connection=ConnectionDB.getConnection();
        // creer la chaine de requete
        String requete="SELECT * FROM proprietaire";
        // appelle a la methode preparedStatement
        pst=connection.prepareStatement(requete);
        // executer la requete en stockant le resultat dans un ResultSet
        rs=pst.executeQuery();
        System.out.println(rs);
        // parcourrir le ResultSet
        Proprietaire model=null;
        while(rs.next()){
           model=new Proprietaire();  
           model.setId(rs.getString("id"));
           model.setNom(rs.getString("nom"));
           model.setPrenom(rs.getString("prenom"));
           model.setSexe(rs.getString("sexe"));
           model.setTel(rs.getString("telephone"));
           model.setAdresse(rs.getString("adresse"));
           model.setTypePiece(rs.getString("typePiece"));
           model.setNoPiece(rs.getString("noPiece"));
           model.setCourriel(rs.getString("courriel"));
           
           // ajouter les objets dans la collection
           listProprietaire.add(model);
        }
        ConnectionDB.closeConnection(rs, pst, connection);
        return listProprietaire;
    }

    @Override
    public Proprietaire get(String id) throws SQLException, ClassNotFoundException {
        // Connection a la base de donnee
        connection = ConnectionDB.getConnection();
        
        //Requete
        String req = "SELECT * FROM proprietaire WHERE id = ?";
        
        //Passage de la requete a la methode preparedStatement
        pst = connection.prepareStatement(req);
        //Passage du parametre a la methode
        pst.setString(1, id);
        
        Proprietaire model = new Proprietaire();//Creation d'une instance de vehicule

        //execution de la requete
        rs = pst.executeQuery();
        while(rs.next()){
           model.setId(rs.getString("id"));
           model.setNom(rs.getString("nom"));
           model.setPrenom(rs.getString("prenom"));
           model.setSexe(rs.getString("sexe"));
           model.setTel(rs.getString("telephone"));
           model.setAdresse(rs.getString("adresse"));
           model.setTypePiece(rs.getString("typePiece"));
           model.setNoPiece(rs.getString("noPiece"));
           model.setCourriel(rs.getString("courriel"));
        }
        return model;
    }

    @Override
    public int save(Proprietaire obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
