package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Donnateur implements Serializable {
   @Id
   public Integer id;
  public String prenom;
    public String nom;
    public String adresse;
    public Integer telephone;
    @Column(nullable = false,unique = true)
    public String typedon;

    @Column(nullable = false,unique = true)
    public String email;
    public Donnateur(Integer id,String prenom,String nom,String adresse,Integer telephone,String typedon, String email){
     this.id = id;
     this.prenom = prenom;
     this.nom = nom;
     this.adresse = adresse;
     this.telephone = telephone;
     this.typedon = typedon;
     this.email = email;

    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public Integer getTelephone() {
        return telephone;
    }
    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
    public String getTypedon() {
        return typedon;
    }
    public void setTypedon(String typedon) {
        this.typedon = typedon;
    }

}
