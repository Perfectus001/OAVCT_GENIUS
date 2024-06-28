/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Christina SARILUS
 */
public class Alerte {
    private String ID;
    private String idvehicule;
    private String typeAlerte;
    private String lieuIncident;
    private Date dateincident;
    private Timestamp heureIncident;
    private String nomDeclarant;
    private String prenomDeclarant;
    private String telDeclarant;
    private String description;
    private java.sql.Timestamp dateEnregistrement;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(String idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getTypeAlerte() {
        return typeAlerte;
    }

    public void setTypeAlerte(String typeAlerte) {
        this.typeAlerte = typeAlerte;
    }

    public String getLieuIncident() {
        return lieuIncident;
    }

    public Date getDateincident() {
        return dateincident;
    }

    public void setDateincident(Date dateincident) {
        this.dateincident = dateincident;
    }

    public void setLieuIncident(String lieuIncident) {
        this.lieuIncident = lieuIncident;
    }

    public Timestamp getHeureIncident() {
        return heureIncident;
    }

    public void setHeureIncident(Timestamp heureIncident) {
        this.heureIncident = heureIncident;
    }

    public String getNomDeclarant() {
        return nomDeclarant;
    }

    public void setNomDeclarant(String nomDeclarant) {
        this.nomDeclarant = nomDeclarant;
    }

    public String getPrenomDeclarant() {
        return prenomDeclarant;
    }

    public void setPrenomDeclarant(String prenomDeclarant) {
        this.prenomDeclarant = prenomDeclarant;
    }

    public String getTelDeclarant() {
        return telDeclarant;
    }

    public void setTelDeclarant(String telDeclarant) {
        this.telDeclarant = telDeclarant;
    }

    public String getDescription() {
        return description;
    }

    public java.sql.Timestamp getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(java.sql.Timestamp dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public Alerte(){
        
    }
    
    //Generateur de code de vehicule
    public String genererCode(){
        Random r=new Random();
        String code=this.typeAlerte.substring(0,3)+
                r.nextInt(9999);
        return code.toUpperCase();
    }
    
    public long calculeDifferenceHeure() {
        //Recuperation de la date et de l'heure actuelle
        java.sql.Timestamp dateActuelle = new java.sql.Timestamp(System.currentTimeMillis());
        
        // Obtenir la différence en millisecondes entre les deux Timestamp
        long diffInMillis = Math.abs(dateActuelle.getTime() - this.dateEnregistrement.getTime());

        // Convertir la différence en millisecondes en heures
        long diffHeure = TimeUnit.MILLISECONDS.toSeconds(diffInMillis);

        return diffHeure;
    }

    public String typeAlerte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDateIncident(java.sql.Date dateincident) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
