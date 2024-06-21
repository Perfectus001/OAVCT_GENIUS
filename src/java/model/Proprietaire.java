/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author Perfectus
 */
public class Proprietaire {
    private String id;
    private String nom;
    private String prenom;
    private String sexe;
    private String tel;
    private String adresse;
    private String typePiece;
    private String noPiece;
    private String courriel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }
    
    public String getNoPiece() {
        return noPiece;
    }

    public void setNoPiece(String noPiece) {
        this.noPiece = noPiece;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
    
    public Proprietaire() {
    }

    public Proprietaire(String id, String nom, String prenom, String sexe, String tel, String adresse, String typePiece, String noPiece, String courriel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.tel = tel;
        this.adresse = adresse;
        this.typePiece = typePiece;
        this.noPiece = noPiece;
        this.courriel = courriel;
    }
    
    public String genererCode(){
        Random r=new Random();
        String code=this.nom.substring(0,1)+
                this.noPiece.substring(0,2)+
                r.nextInt(9999);
        return code.toUpperCase();
    }
}
