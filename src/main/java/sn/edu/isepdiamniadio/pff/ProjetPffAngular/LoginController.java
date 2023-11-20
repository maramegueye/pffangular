package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

     @PutMapping
    @CrossOrigin(origins="*",methods = RequestMethod.PUT)
    public Authentification connect(@RequestBody LoginForm loginForm){
        String email=loginForm.getEmail();
        String password=loginForm.getPassword();
        System.out.println("login de"+loginForm);
        Authentification authentification = adminService.connexion(email, password);
        System.out.println("authentification="+authentification);
        return authentification;


    }
    
}
