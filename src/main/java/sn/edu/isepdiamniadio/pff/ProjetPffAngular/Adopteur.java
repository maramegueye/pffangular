package sn.edu.isepdiamniadio.pff.ProjetPffAngular;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class Adopteur implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String prenom;
    private String nom;
    private String adresse;
    private Integer telephone;

    @Column(nullable = false,unique = true)
    private String email;

    @ManyToOne
    private RendezVous rendezVous;
 
    public Adopteur(){}
    
    public Adopteur(Integer id,String prenom,String nom,String adresse,Integer telephone, String email){
    this.id = id;
     this.prenom = prenom;
     this.nom = nom;
     this.adresse = adresse;
     this.telephone = telephone;
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
}