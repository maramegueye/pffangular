package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AuthentificationRepository authentificationRepository;

    public List<Admin> getAdmins(){
        return this.adminRepository.findAll();
    }

    public Optional<Admin> FindAdmin(Integer id){
        return this.adminRepository.findById(id);
    }

    public void saveAdmin(Admin admin){
        this.adminRepository.save(admin);
    }

    public void deleteAdmin(Integer id){
        this.adminRepository.deleteById(id);
    }

    public Authentification connexion(String email,String password){
        Admin admin = this.adminRepository.findAdminByEmail(email);
        String pwdHash= IsepUtil.sha512(password); //pour calculer le hash du mot de passe
        if (admin==null || !admin.getPassword().equals(pwdHash)) {
           return null; 
        }
       
        // if (!apprenant.getPassword().equals(pwdHash)) {
        //     return null;
            
        // }
        Authentification res = new Authentification(); 
        res.setAdmin(admin);
        Date now = new Date();
        res.setDateCreation(now);
        res.setValidate(new Date(now.getTime()+(30*60*1000)));
        String token = generateToken(); // pour gerer aleatoire 20 caracterers
        res.setToken(token);
        authentificationRepository.save(res);
        return res;
      }
      private String generateToken(){
        int longToken = 20;
        String alphabet = "0123456789abcdefghijklmNPQGHZX";
        String token = "";
        for(int i = 0; i<longToken; i++){
            int n =(int) (Math.random() * alphabet.length());// donne un nombre entre 0 taille de alphabet
            char c = alphabet.charAt(n);
            token += c;
        }
    
        return token;
      }

    
}
