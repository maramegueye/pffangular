package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
@Entity
@Table
public class DemandeAdoption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private  String nom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telephone;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private Date dateDemande;
    private String message;

 public DemandeAdoption(){

 }
    
    public DemandeAdoption(Integer id, String prenom, String nom, String email, String telephone, Date dateDemande,
    String message) {
    this.id = id;
    this.prenom = prenom;
    this.nom = nom;
    this.email = email;
    this.telephone = telephone;
    this.dateDemande = dateDemande;
    this.message = message;
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PrePersist
    public void  avantCreation(){
        this.dateDemande = new Date();

    }
  
    




    
}
