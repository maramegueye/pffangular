package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class RendezVous implements Serializable {
    @Id
    public Date date;
    public String heure;
    public RendezVous(Date date, String heure){
        this.date = date;
        this.heure = heure;
}
  public Date getDate() {
      return date;
  }
  public void setDate(Date date) {
      this.date = date;
  }
  public String getHeure() {
      return heure;
  }
public void setHeure(String heure) {
    this.heure = heure;
}
}