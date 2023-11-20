package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.Serializable;

public class LoginForm implements Serializable {

    private String email;
    private String password;

    public LoginForm(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm [email=" + email + ", password=" + password + "]";
    }
    
    
}
