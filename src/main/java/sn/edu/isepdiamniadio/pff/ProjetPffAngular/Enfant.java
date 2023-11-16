package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class Enfant  implements Serializable{
      @Id
    public Integer id;
    @Column(nullable = false,unique = true)
    public String prenom;
    public String nom;
    public Integer age;
    public Date date_naissance;

    @Lob
    public byte Photo;


    @ManyToOne
 public Adopteur adopteur;


    public Enfant(Integer id,String prenom,String nom, Integer age, Date date_naissance, byte photo){
    this.id = id;
     this.prenom = prenom;
     this.nom = nom;
     this.age = age;
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
    
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Enfant() {
    }
    public byte getPhoto() {
        return Photo;
    }
    public void setPhoto(byte photo) {
        Photo = photo;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void updatePhoto(byte[] photobyte, Enfant enfant2) {
    }
}
