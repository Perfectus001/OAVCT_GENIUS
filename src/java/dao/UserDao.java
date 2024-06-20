/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.ConnectionDB;
import model.User;
import java.sql.SQLException;

/**
 *
 * @author Perfectus
 */
public class UserDao {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public User getUser(String user, String pwd) throws SQLException, ClassNotFoundException {
        // recuperation de la connection
        connection = ConnectionDB.getConnection();
        //  definir la chaine de requete
        String sql = " SELECT * FROM USERS WHERE USERNAME=? AND PASSWD=? AND ETAT='ON'";
        // passage de la requete
        pst = connection.prepareStatement(sql);
        // passage des parametres
        pst.setString(1, user);
        pst.setString(2, pwd);
        // executer la requete
        rs = pst.executeQuery();
        // creer un UsersModel
        User model = null;
        if (rs.next()) {
            model = new User();
            model.setUsername(rs.getString("username"));
            model.setPassword(rs.getString("passwd"));
            model.setFonction(rs.getString("fonction"));
        }
        ConnectionDB.closeConnection(rs, pst, connection);
        return model;
    }
}
