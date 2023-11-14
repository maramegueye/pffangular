package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table
    
public class Personnel implements Serializable {
  
    @Id
    private Integer id;
    private String nom;
    private String prenom;

    @Column(nullable = false)
    private String profil;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String adrresse;

    public Personnel(Integer id, String nom, String prenom, String profil, String telephone, String adrresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.profil = profil;
        this.telephone = telephone;
        this.adrresse = adrresse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdrresse() {
        return adrresse;
    }

    public void setAdrresse(String adrresse) {
        this.adrresse = adrresse;
    }
    

}
