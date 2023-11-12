package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class Enfant  implements Serializable{
      @Id
    public Integer id;
    // @Column(name =  "prenom_apprenant",nullable = false,unique = true)
    @Column(nullable = false,unique = true)
    public String prenom;
    public String nom;
    public Date date_naissance;
    public String Photo;
    @ManyToOne
 public Adopteur adopteur;
//  @OneToOne

//  @JoinColumn(name = "num_carte",nullable = true) // pour changer le nom de la colonne
  
//  private CarteEtudiant carteEtudiant;
 
// @ManyToOne
// // @JoinColumn(name = "filiere",nullable = true)
// private Filiere filiere;
// @ManyToOne
// // @JoinColumn(name ="Promotion",nullable = true )
// private Promotion promotion;
    // public Apprenant(){
 
    // }
    public Enfant(Integer id,String prenom,String nom,Date date_naissance, String photo){
    this.id = id;
     this.prenom = prenom;
     this.nom = nom;
     this.date_naissance = date_naissance;
     this.Photo = photo ;
    }
    public Date getDate_naissance() {
        return date_naissance;
    }
    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
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
    public String getPhoto() {
        return Photo;
    }
    public void setPhoto(String photo) {
        Photo = photo;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
