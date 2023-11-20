package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

   @Autowired
    private AdminService AdminService;
    
     @GetMapping
    // @CrossOrigin("http://localhost:4200")
    public List<Admin> getAdmins(){
        return this.AdminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin FindAdmin(@PathVariable Integer id){
        Optional<Admin> app = this.AdminService.FindAdmin(id);
        return app.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Integer id){
        this.AdminService.deleteAdmin(id);
    }

    @PutMapping()
    public void ajoutApprenant(@RequestBody Admin admin){
        this.AdminService.saveAdmin(admin);
    }
}
