package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Authentification implements Serializable{
    
    @Id 
    private String token;
    private Date dateCreation;
    private Date validate;

    @ManyToOne
    private Admin admin;

    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getValidate() {
        return validate;
    }

    public void setValidate(Date validate) {
        this.validate = validate;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Authentification [token=" + token + ", dateCreation=" + dateCreation + ", validate=" + validate
                + ", admin=" + admin + "]";
    }





  
}
