package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/enfants")
public class EnfantController {

      @Autowired
    private EnfantService enfantService;

    @GetMapping
    
    public List<Enfant> getEnfant(){
        return this.enfantService.getEnfants();
    }
      
    

    @GetMapping("/{id}")
    
    public Enfant findEnfant(@PathVariable Integer id){
        Optional<Enfant> app = this.enfantService.findById(id);

        return app.orElse(null);
        
            

        }
       
    @DeleteMapping("/{id}")
    public void deleteEnfant(@PathVariable Integer id){
        this.enfantService.deleteById(id);
    }


    @PutMapping
    @CrossOrigin(origins = "*" ,methods= RequestMethod.PUT)
    public void ajouterEnfant(@RequestBody Enfant enfant){
       
        this.enfantService.save(enfant);
    
    }

    @PostMapping(value = "/save-photoEnfant")
    public boolean handleFileUpload(@RequestParam("Enfant") Enfant enfant,
                                    @RequestParam("file") MultipartFile file) throws IOException {
        return enfantService.store(file, enfant);
    } 
    
}
