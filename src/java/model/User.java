/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Perfectus
 */
public class User {
    private String username;
    private String password;
    private String fonction;
    private String etat;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public User(String username, String password, String fonction, String etat) {
        this.username = username;
        this.password = password;
        this.fonction = fonction;
        this.etat = etat;
    }

    public User() {
    }

    @Override
    public String toString() {
        return  fonction;
    }

    
    
    
    
}
