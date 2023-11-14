package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class EffectifTotal implements Serializable{

   @Id
    private Integer id;

    @Column(nullable = false)
    private String nbrfilles;

     @Column(nullable = false)
    private String nbrgarcons;

     @Column(nullable = false)
    private String nbrtotal;

    public EffectifTotal(Integer id, String nbrfilles, String nbrgarcons, String nbrtotal) {
        this.id = id;
        this.nbrfilles = nbrfilles;
        this.nbrgarcons = nbrgarcons;
        this.nbrtotal = nbrtotal;
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

   


    
}
