/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.List;
import database.ConnectionDB;
import model.Vehicule;

/**
 *
 * @author Perfectus
 */
public class VehiculeDao implements IDao<Vehicule>{
Connection connection=null;
PreparedStatement pst=null;
ResultSet rs=null;
    @Override
    public int save(Vehicule vehicule) throws SQLException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="INSERT INTO Vehicule (id, marque, modele, noMoteur, nbCylindre, couleur, typeTransmission, typeEssence, photoVehicule, plaqueImmatriculation, nomProprietaire, prenomProprietaire, sexeProprietaire, telProprietaire, adresseProprietaire, typePieceProp, noPiece, annee, courrielProprietaire, alerte, dateAlerte, dateEnregistrement) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);

            // passage des parametres a la requete
            pst.setString(1, vehicule.genererCode());
            pst.setString(2, vehicule.getMarque());
            pst.setString(3, vehicule.getModele());
            pst.setString(4, vehicule.getNoMoteur());
            pst.setInt(5, vehicule.getNbCylindre());
            pst.setString(6, vehicule.getCouleur());
            pst.setString(7, vehicule.getTypeTransmission());
            pst.setString(8, vehicule.getTypeEssence());
            pst.setBytes(9, vehicule.getPhotoVehicule());
            pst.setString(10, vehicule.getPlaqueImmatriculation());
            pst.setString(11, vehicule.getNomProprietaire());
            pst.setString(12, vehicule.getPrenomProprietaire());
            pst.setString(13, vehicule.getSexeProprietaire());
            pst.setString(14, vehicule.getTelProprietaire());
            pst.setString(15, vehicule.getAdresseProprietaire());
            pst.setString(16, vehicule.getTypePieceProp());
            pst.setString(17, vehicule.getNoPiece());
            pst.setInt(18, vehicule.getAnnee());
            pst.setString(19, vehicule.getCourrierProprietaire());
            pst.setBoolean(20, vehicule.isAlerte());
            pst.setDate(21, Date.valueOf(vehicule.getDateAlerte()));
            pst.setDate(22, new java.sql.Date(System.currentTimeMillis()));  
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }
                
        return 0;
    }

    @Override
    public int update(Vehicule obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehicule> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehicule get(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
