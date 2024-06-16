/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Perfectus
 */
public class Vehicule {
    private String id;
    private String marque;
    private String couleur;
    private String modele;
    private String noMoteur;
    private int nbCylindre;
    private String typeTransmission;
    private String typeEssence;
    private byte[] photoVehicule;
    private String plaqueImmatriculation;
    private String nomProprietaire;
    private String prenomProprietaire;
    private String sexeProprietaire;
    private String telProprietaire;
    private String adresseProprietaire;
    private String typePieceProp;
    private String noPiece;
    private int annee;
    private String courrierProprietaire;
    private boolean alerte;
    private LocalDate dateAlerte;
    private Date dateEnregistrement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNoMoteur() {
        return noMoteur;
    }

    public void setNoMoteur(String noMoteur) {
        this.noMoteur = noMoteur;
    }

    public int getNbCylindre() {
        return nbCylindre;
    }

    public void setNbCylindre(int nbCylindre) {
        this.nbCylindre = nbCylindre;
    }

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission;
    }

    public String getTypeEssence() {
        return typeEssence;
    }

    public void setTypeEssence(String typeEssence) {
        this.typeEssence = typeEssence;
    }

    public byte[] getPhotoVehicule() {
        return photoVehicule;
    }

    public void setPhotoVehicule(byte[] photoVehicule) {
        this.photoVehicule = photoVehicule;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    public String getSexeProprietaire() {
        return sexeProprietaire;
    }

    public void setSexeProprietaire(String sexeProprietaire) {
        this.sexeProprietaire = sexeProprietaire;
    }

    public String getTelProprietaire() {
        return telProprietaire;
    }

    public void setTelProprietaire(String telProprietaire) {
        this.telProprietaire = telProprietaire;
    }

    public String getAdresseProprietaire() {
        return adresseProprietaire;
    }

    public void setAdresseProprietaire(String adresseProprietaire) {
        this.adresseProprietaire = adresseProprietaire;
    }

    public String getTypePieceProp() {
        return typePieceProp;
    }

    public void setTypePieceProp(String typePieceProp) {
        this.typePieceProp = typePieceProp;
    }

    public String getNoPiece() {
        return noPiece;
    }

    public void setNoPiece(String noPiece) {
        this.noPiece = noPiece;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCourrierProprietaire() {
        return courrierProprietaire;
    }

    public void setCourrierProprietaire(String courrierProprietaire) {
        this.courrierProprietaire = courrierProprietaire;
    }

    public boolean isAlerte() {
        return alerte;
    }

    public void setAlerte(boolean alerte) {
        this.alerte = alerte;
    }

    public LocalDate getDateAlerte() {
        return dateAlerte;
    }

    public void setDateAlerte(LocalDate dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }
    

    public Vehicule() {
    }
    
    public Vehicule(String id, String marque, String couleur, String modele, 
                    String noMoteur, int nbCylindre, String typeTransmission, 
                    String typeEssence, byte[] photoVehicule, 
                    String plaqueImmatriculation, String nomProprietaire, 
                    String prenomProprietaire, String sexeProprietaire, 
                    String telProprietaire, String adresseProprietaire, 
                    String typePieceProp, String noPiece, int annee, 
                    String courrierProprietaire, boolean alerte, 
                    LocalDate dateAlerte, Date dateEnregistrement) {
        this.id = id;
        this.marque = marque;
        this.couleur = couleur;
        this.modele = modele;
        this.noMoteur = noMoteur;
        this.nbCylindre = nbCylindre;
        this.typeTransmission = typeTransmission;
        this.typeEssence = typeEssence;
        this.photoVehicule = photoVehicule;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.nomProprietaire = nomProprietaire;
        this.prenomProprietaire = prenomProprietaire;
        this.sexeProprietaire = sexeProprietaire;
        this.telProprietaire = telProprietaire;
        this.adresseProprietaire = adresseProprietaire;
        this.typePieceProp = typePieceProp;
        this.noPiece = noPiece;
        this.annee = annee;
        this.courrierProprietaire = courrierProprietaire;
        this.alerte = alerte;
        this.dateAlerte = dateAlerte;
        this.dateEnregistrement = dateEnregistrement;
    }
    
    //Generateur de code de vehicule
    public String genererCode(){
        Random r=new Random();
        String code=this.marque.substring(0,1)+
                this.noMoteur.substring(0,2)+
                r.nextInt(9999);
        return code.toUpperCase();
    }
}
