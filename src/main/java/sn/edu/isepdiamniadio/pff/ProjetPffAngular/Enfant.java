package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
// import java.util.Date;
import java.util.Date;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class Enfant  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false,unique = true)
    public String prenom;
    public String nom;
    public Integer age;
    public Date datenaissance;
   

    @Lob
    @Column(columnDefinition = "BLOB")
    public byte[] photo;

    @ManyToOne
    public Adopteur adopteur;   

    public Enfant(){

    }
    
    public Enfant(Integer id, String prenom, String nom, Integer age, Date datenaissance, byte[] photo,
        Adopteur adopteur) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.datenaissance = datenaissance;
        this.photo = photo;
        this.adopteur = adopteur;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   public Date getDatenaissance() {
       return datenaissance;
   }
   public void setDatenaissance(Date datenaissance) {
       this.datenaissance = datenaissance;
   }
    

    // public Date getDateNaissance() {
    //     return dateNaissance;
    // }

    // public void setDateNaissance(Date dateNaissance) {
    //     this.dateNaissance = dateNaissance;
    // }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Adopteur getAdopteur() {
        return adopteur;
    }

    public void setAdopteur(Adopteur adopteur) {
        this.adopteur = adopteur;
    }
    
   
}