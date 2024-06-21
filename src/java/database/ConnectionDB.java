/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author Perfectus
 */
public class ConnectionDB {
    private static Connection con=null;
   
   public static Connection getConnection() throws ClassNotFoundException, SQLException{
       // charger le driver (pilote) de la BD
       Class.forName("com.mysql.cj.jdbc.Driver");
       // etablir la connection a la BD
       // url
       String url="jdbc:mysql://localhost:3306/oavct_db2";
       con=DriverManager.getConnection(url,"root","");
       return con;
   }
   
   public static void closeConnection(ResultSet rs,PreparedStatement pst,Connection con)throws SQLException{
       if(rs!=null){
           rs.close();
       }
        if(pst!=null){
           pst.close();
       }
         if(con!=null){
           con.close();
       }
   }
}
