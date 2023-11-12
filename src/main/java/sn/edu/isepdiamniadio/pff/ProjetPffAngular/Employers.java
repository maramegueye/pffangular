package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Employers implements Serializable {
    @Id
   public Integer id;
  public String prenom;
    public String nom;
    public String adresse;
    public Integer telephone;
    public String salaire;
     @Column(nullable = false,unique = true)
     public String profile;
   
    

 public Employers(Integer id,String prenom,String nom,String adresse,Integer telephone,String salaire, String profile){
   this.id = id;
   this.prenom = prenom;
   this.nom = nom;
   this.adresse = adresse;
   this.telephone = telephone;
   this.salaire = salaire;
   this.profile = profile;
 }  
 public String getAdresse() {
     return adresse;
 } 
 public void setAdresse(String adresse) {
     this.adresse = adresse;
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
 public String getProfile() {
     return profile;
 }
 public void setProfile(String profile) {
     this.profile = profile;
 }
 public String getSalaire() {
     return salaire;
 }
 public void setSalaire(String salaire) {
     this.salaire = salaire;
 }
 public Integer getTelephone() {
     return telephone;
 }
 public void setTelephone(Integer telephone) {
     this.telephone = telephone;
 }
 
}
