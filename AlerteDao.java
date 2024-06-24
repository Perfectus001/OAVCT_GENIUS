/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Alerte;

/**
 *
 * @author Christina SARILUS
 */
public class AlerteDao implements IDao<Alerte>{
    Connection connection=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public int saveAl(Alerte alerte, String id) throws SQLException, ClassNotFoundException {
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="INSERT INTO Alertevahicule (id, idvehicule, typeAlerte, lieuIncident, heureIncident, nom_declarant, prenom_declarant, tel_declarant, description, dateEnregistrement) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);
            
            // passage des parametres a la requete
            pst.setString(1, alerte.genererCode());
            pst.setString(2, id);
            pst.setString(3, alerte.getTypeAlerte());
            pst.setString(4, alerte.getLieuIncident());
            pst.setTimestamp(5, alerte.getHeureIncident() );
            pst.setString(6, alerte.getNomDeclarant());
            pst.setString(7, alerte.getPrenomDeclarant());
            pst.setString(8, alerte.getTelDeclarant());
            pst.setString(9, alerte.getDescription());
            pst.setTimestamp(10, new java.sql.Timestamp(System.currentTimeMillis())); 
    }

    return 0;
   }

    @Override
    public int save(Alerte obj) throws SQLException, ClassNotFoundException {
    return 0;
    }

    @Override
    public int update(Alerte alerte ) throws SQLException, ClassNotFoundException{
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        // recuperation de la connection a la database
        connection = ConnectionDB.getConnection();
        
        if(connection != null){
            //creation la chaine de requete
            String requete="UPDATE Alerte SET typeAlerte=?, c=?, heureIncident=?, nom_declarant=?, prenom_declarant=?, tel_declatant=?, description=?";

            // Utilisation de la methode preparedStatement
            pst=connection.prepareStatement(requete);

            // passage des parametres a la requete
            //pst.setString(1, vehicule.genererCode());
            pst.setString(1, alerte.getTypeAlerte());
            pst.setString(2, alerte.getLieuIncident());
            pst.setString(4, alerte.getNomDeclarant());
            pst.setString(5, alerte.getPrenomDeclarant());
            pst.setString(6, alerte.getTelDeclarant());
            pst.setString(7, alerte.getDescription());
            }
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
    public List<Alerte> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alerte get(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
