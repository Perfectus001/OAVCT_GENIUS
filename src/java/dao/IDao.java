/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.sql.*;

/**
 *
 * @author Perfectus
 * @param <type>
 */
public interface IDao<type> {
    public int save(type obj)throws SQLException,ClassNotFoundException;

    int update(type obj)throws SQLException,ClassNotFoundException;
 
    int delete(String id)throws SQLException,ClassNotFoundException;

    List<type> getAll()throws SQLException,ClassNotFoundException;

    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    type get(String id)throws SQLException,ClassNotFoundException;
}