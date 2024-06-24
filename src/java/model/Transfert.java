/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author Perfectus
 */
public class Transfert {
    private int id;
    private String idVehicule;
    private String idExProprietaire;
    private String idNewProprietaire;
    private String motifTransfert;
    private Date dateTransfert;
    private String etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(String idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getIdExProprietaire() {
        return idExProprietaire;
    }

    public void setIdExProprietaire(String idExProprietaire) {
        this.idExProprietaire = idExProprietaire;
    }

    public String getIdNewProprietaire() {
        return idNewProprietaire;
    }

    public void setIdNewProprietaire(String idNewProprietaire) {
        this.idNewProprietaire = idNewProprietaire;
    }

    public String getMotifTransfert() {
        return motifTransfert;
    }

    public void setMotifTransfert(String motifTransfert) {
        this.motifTransfert = motifTransfert;
    }

    public Date getDateTransfert() {
        return dateTransfert;
    }

    public void setDateTransfert(Date dateTransfert) {
        this.dateTransfert = dateTransfert;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Transfert() {
    }

    public Transfert(int id, String idVehicule, String idExProprietaire, String idNewProprietaire, String motifTransfert, Date dateTransfert, String etat) {
        this.id = id;
        this.idVehicule = idVehicule;
        this.idExProprietaire = idExProprietaire;
        this.idNewProprietaire = idNewProprietaire;
        this.motifTransfert = motifTransfert;
        this.dateTransfert = dateTransfert;
        this.etat = etat;
    }
    
}
