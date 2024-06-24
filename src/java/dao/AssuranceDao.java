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
import java.util.List;
import model.Assurance;
import java.util.ArrayList;

/**
 *
 * @author Perfectus
 */
public class AssuranceDao implements IDao<Assurance> {
    Connection connection=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @Override
    public int save(Assurance assurance) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        if(connection != null){
            //creation la chaine de requete
            String requete="INSERT INTO Assurance (id, idVehicule, montantAssurance, datePaiement, dateFinAssurance) VALUES (?, ?, ?, ?, ?)";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);
            // passage des parametres a la requete
            pst.setString(1, assurance.genererCode());
            pst.setString(2, assurance.getIdVehicule());
            pst.setDouble(3, assurance.getMontantAssurance());
            pst.setDate(4, assurance.getDatePaiement());
            pst.setDate(5, assurance.getDateFinAssurance());
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }   
        return 0;
    }

    @Override
    public int update(Assurance obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Assurance> getAll() throws SQLException, ClassNotFoundException {
        // creer une liste generique
        List<Assurance> listAssurance=new ArrayList<>();
        // recuperation de la connexion a la BD
        connection=ConnectionDB.getConnection();
        // creer la chaine de requete
        String requete="SELECT * FROM assurance";
        // appelle a la methode preparedStatement
        pst=connection.prepareStatement(requete);
        // executer la requete en stockant le resultat dans un ResultSet
        rs=pst.executeQuery();
        
        // parcourrir le ResultSet
        Assurance model=null;
        while(rs.next()){
           model=new Assurance();  
           model.setId(rs.getString("id"));
           model.setIdVehicule(rs.getString("idVehicule"));
           model.setMontantAssurance(Double.parseDouble(rs.getString("montantAssurance")) );
           model.setDatePaiement(rs.getDate("datePaiement"));
           model.setDateFinAssurance(rs.getDate("dateFinAssurance"));
           
           // ajouter les objets dans la collection
           listAssurance.add(model);
        }
        ConnectionDB.closeConnection(rs, pst, connection);
        return listAssurance;
    }

    @Override
    public Assurance get(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean betweenDate(Assurance assurance){
        
        
        return false;
    }
    
}
