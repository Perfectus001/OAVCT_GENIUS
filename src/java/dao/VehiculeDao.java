/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.List;
import database.ConnectionDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
            pst.setString(19, vehicule.getCourrielProprietaire());
            pst.setBoolean(20, vehicule.isAlerte());
            if(vehicule.isAlerte()){
                pst.setDate(21, new Date(System.currentTimeMillis()));
            }else{
                pst.setDate(21, null);
            }
            pst.setTimestamp(22, new java.sql.Timestamp(System.currentTimeMillis())); 
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }
                
        return 0;
    }

    @Override
    public int update(Vehicule vehicule) throws SQLException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="UPDATE Vehicule SET marque=?, modele=?, noMoteur=?, nbCylindre=?, couleur=?, typeTransmission=?, typeEssence=?, photoVehicule=?, plaqueImmatriculation=?, nomProprietaire=?, prenomProprietaire=?, sexeProprietaire=?, telProprietaire=?, adresseProprietaire=?, typePieceProp=?, noPiece=?, annee=?, courrielProprietaire=?, alerte=?- WHERE id=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);

            // passage des parametres a la requete
            //pst.setString(1, vehicule.genererCode());
            pst.setString(1, vehicule.getMarque());
            pst.setString(2, vehicule.getModele());
            pst.setString(3, vehicule.getNoMoteur());
            pst.setInt(4, vehicule.getNbCylindre());
            pst.setString(5, vehicule.getCouleur());
            pst.setString(6, vehicule.getTypeTransmission());
            pst.setString(7, vehicule.getTypeEssence());
            pst.setBytes(8, vehicule.getPhotoVehicule());
            pst.setString(9, vehicule.getPlaqueImmatriculation());
            pst.setString(10, vehicule.getNomProprietaire());
            pst.setString(11, vehicule.getPrenomProprietaire());
            pst.setString(12, vehicule.getSexeProprietaire());
            pst.setString(13, vehicule.getTelProprietaire());
            pst.setString(14, vehicule.getAdresseProprietaire());
            pst.setString(15, vehicule.getTypePieceProp());
            pst.setString(16, vehicule.getNoPiece());
            pst.setInt(17, vehicule.getAnnee());
            pst.setString(18, vehicule.getCourrielProprietaire());
            pst.setBoolean(19, vehicule.isAlerte());
            /*if(vehicule.getDateAlerte() != null){
                pst.setDate(20, java.sql.Date.valueOf(vehicule.getDateAlerte()));
            }else{
                pst.setDate(20, null);
            } */
            pst.setString(21, vehicule.getId());
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }
                
        return 0;
    }
    
    public int desactiverAlerte(Vehicule vehicule) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="UPDATE Vehicule SET alerte=?, dateAlerte=? WHERE id=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);
            
            pst.setBoolean(1, !vehicule.isAlerte());
            pst.setDate(2, null);
            //pst.setDate(2, new Date(System.currentTimeMillis()));
            
            pst.setString(3, vehicule.getId());
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }
        return 0;
    }
    
    public int activerAlerte(Vehicule vehicule) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="UPDATE Vehicule SET alerte=?, dateAlerte=? WHERE id=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);
            
            pst.setBoolean(1, !vehicule.isAlerte());
            pst.setDate(2, new Date(System.currentTimeMillis()));
            
            pst.setString(3, vehicule.getId());
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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="DELETE FROM Vehicule WHERE id=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);

            // passage de parametres a la requete
            pst.setString(1, id);
            // execution la requete
            int n = pst.executeUpdate();

            // fermer les connections
            ConnectionDB.closeConnection(rs, pst, connection);

            return n;
        }    
        return 0;
    }

    @Override
    public List<Vehicule> getAll() throws SQLException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
              // creer une liste generique
      List<Vehicule> listVehicule=new ArrayList<>();
        // recuperation de la connexion a la BD
        connection=ConnectionDB.getConnection();
        // creer la chaine de requete
        String requete="SELECT * FROM vehicule";
        // appelle a la methode preparedStatement
        pst=connection.prepareStatement(requete);
        // executer la requete en stockant le resultat dans un ResultSet
        rs=pst.executeQuery();
        System.out.println(rs);
        // parcourrir le ResultSet
        Vehicule model=null;
        while(rs.next()){
           model=new Vehicule();  
           model.setId(rs.getString("id"));
           model.setMarque(rs.getString("marque"));
           model.setCouleur(rs.getString("couleur"));
           model.setModele(rs.getString("modele"));
           model.setNoMoteur(rs.getString("noMoteur"));
           model.setNbCylindre(rs.getInt("nbCylindre"));
           model.setTypeTransmission(rs.getString("typeTransmission"));
           model.setTypeEssence(rs.getString("typeEssence"));
           model.setPhotoVehicule(rs.getBytes("photoVehicule"));
           model.setPlaqueImmatriculation(rs.getString("plaqueImmatriculation"));
           model.setNomProprietaire(rs.getString("nomProprietaire"));
           model.setPrenomProprietaire(rs.getString("prenomProprietaire"));
           model.setSexeProprietaire(rs.getString("sexeProprietaire"));
           model.setTelProprietaire(rs.getString("telProprietaire"));
           model.setAdresseProprietaire(rs.getString("adresseProprietaire"));
           model.setTypePieceProp(rs.getString("typePieceProp"));
           model.setNoPiece(rs.getString("noPiece"));
           model.setAnnee(rs.getInt("annee"));
           model.setCourrielProprietaire(rs.getString("courrielProprietaire"));
           model.setAlerte(rs.getBoolean("alerte"));
           /*if(rs.getString("alerte").equalsIgnoreCase("1")){
                model.setAlerte(true);
            }else{
                model.setAlerte(true);
            }*/
            if(rs.getDate("dateAlerte") != null){
                LocalDate dateAlerte = LocalDate.parse(rs.getString("dateAlerte"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                model.setDateAlerte(dateAlerte);
            }else{
                model.setDateAlerte(null);
            }
            model.setDateEnregistrement(java.sql.Timestamp.valueOf(rs.getString("dateEnregistrement")));
           
           // ajouter les objets dans la collection
           listVehicule.add(model);
        }
        ConnectionDB.closeConnection(rs, pst, connection);
        return listVehicule;
    }

    @Override
    public Vehicule get(String id) throws SQLException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // Connection a la base de donnee
        connection = ConnectionDB.getConnection();
        
        //Requete
        String req = "SELECT * FROM vehicule WHERE id = ?";
        
        //Passage de la requete a la methode preparedStatement
        pst = connection.prepareStatement(req);
        //Passage du parametre a la methode
        pst.setString(1, id);
        
        Vehicule model = new Vehicule();//Creation d'une instance de vehicule

        //execution de la requete
        rs = pst.executeQuery();
        while(rs.next()){
           model.setId(rs.getString("id"));
           model.setMarque(rs.getString("marque"));
           model.setCouleur(rs.getString("couleur"));
           model.setModele(rs.getString("modele"));
           model.setNoMoteur(rs.getString("noMoteur"));
           model.setNbCylindre(rs.getInt("nbCylindre"));
           model.setTypeTransmission(rs.getString("typeTransmission"));
           model.setTypeEssence(rs.getString("typeEssence"));
           model.setPhotoVehicule(rs.getBytes("photoVehicule"));
           model.setPlaqueImmatriculation(rs.getString("plaqueImmatriculation"));
           model.setNomProprietaire(rs.getString("nomProprietaire"));
           model.setPrenomProprietaire(rs.getString("prenomProprietaire"));
           model.setSexeProprietaire(rs.getString("sexeProprietaire"));
           model.setTelProprietaire(rs.getString("telProprietaire"));
           model.setAdresseProprietaire(rs.getString("adresseProprietaire"));
           model.setTypePieceProp(rs.getString("typePieceProp"));
           model.setNoPiece(rs.getString("noPiece"));
           model.setAnnee(rs.getInt("annee"));
           model.setCourrielProprietaire(rs.getString("courrielProprietaire"));
           model.setAlerte(rs.getBoolean("alerte"));
           /*if(rs.getString("alerte").equalsIgnoreCase("1")){
                model.setAlerte(true);
            }else{
                model.setAlerte(true);
            }*/
            if(rs.getDate("dateAlerte") != null){
                LocalDate dateAlerte = LocalDate.parse(rs.getString("dateAlerte"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                model.setDateAlerte(dateAlerte);
            }else{
                model.setDateAlerte(null);
            }
            model.setDateEnregistrement(java.sql.Timestamp.valueOf(rs.getString("dateEnregistrement")));
        }
        return model;
    }
    
}
