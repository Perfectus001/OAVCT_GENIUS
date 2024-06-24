/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.util.Random;

/**
 *
 * @author Perfectus
 */
public class Assurance {
    private String id;
    private String idVehicule;
    private double montantAssurance;
    private Date datePaiement;
    private Date dateFinAssurance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(String idVehicule) {
        this.idVehicule = idVehicule;
    }

    public double getMontantAssurance() {
        return montantAssurance;
    }

    public void setMontantAssurance(double montantAssurance) {
        this.montantAssurance = montantAssurance;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }
    
    public Date getDateFinAssurance() {
        return dateFinAssurance;
    }

    public void setDateFinAssurance(Date dateFinAssurance) {
        this.dateFinAssurance = dateFinAssurance;
    }

    public Assurance() {
    }
    
    public Assurance(String id, String idVehicule, double montantAssurance, Date datePaiement, Date dateFinAssurance) {
        this.id = id;
        this.idVehicule = idVehicule;
        this.montantAssurance = montantAssurance;
        this.datePaiement = datePaiement;
        this.dateFinAssurance = dateFinAssurance;
    }

    public String genererCode() {
                Random r=new Random();
        String code=this.idVehicule.substring(0,3)+
                r.nextInt(9999);
        return code.toUpperCase();
    }

}
