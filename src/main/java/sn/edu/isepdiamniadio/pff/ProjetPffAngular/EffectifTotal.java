package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class EffectifTotal implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nbrfilles;

     @Column(nullable = false)
    private String nbrgarcons;

     @Column(nullable = false)
    private String nbrtotal;

      @Column(nullable = false)
    private String entre_enfants;

      @Column(nullable = false)
    private String sotie_enfants;

    public EffectifTotal() {
        // Default constructor is needed by Hibernate
    }

    public EffectifTotal(Integer id, String nbrfilles, String nbrgarcons, String nbrtotal,String entre_enfants, String sotie_enfants) {
        this.id = id;
        this.nbrfilles = nbrfilles;
        this.nbrgarcons = nbrgarcons;
        this.nbrtotal = nbrtotal;
        this.entre_enfants = entre_enfants;
        this.sotie_enfants = sotie_enfants;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNbrfilles() {
        return nbrfilles;
    }

    public void setNbrfilles(String nbrfilles) {
        this.nbrfilles = nbrfilles;
    }

    public String getNbrgarcons() {
        return nbrgarcons;
    }

    public void setNbrgarcons(String nbrgarcons) {
        this.nbrgarcons = nbrgarcons;
    }

    public String getNbrtotal() {
        return nbrtotal;
    }

    public void setNbrtotal(String nbrtotal) {
        this.nbrtotal = nbrtotal;
    }
    public String getEntre_enfants() {
        return entre_enfants;
    }
    public void setEntre_enfants(String entre_enfants) {
        this.entre_enfants = entre_enfants;
    }
    public String getSotie_enfants() {
        return sotie_enfants;
    }
    public void setSotie_enfants(String sotie_enfants) {
        this.sotie_enfants = sotie_enfants;
    }

   


    
}
