package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personnels")

public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping
    
    public List<Personnel> getPersonnels(){
        return this.personnelService.getPersonnels();
    } 
    @GetMapping("/{id}")
    public Personnel FindPersonnels(@PathVariable Integer id){
        Optional <Personnel> app = this.personnelService.FindPersonnels(id);
        return app.orElse(null);
    }
    
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Object> deletePersonnel(@PathVariable Integer id) {
      Personnel personnel = FindPersonnels(id);
      if (personnel==null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("suppression reussi" +id+" n'exite pas");
  
      }
      this.personnelService.deletePersonnels(id);
      return ResponseEntity.status(HttpStatus.OK).body("suppression  reussi de la demande  numero"+id);
      
     }
    @PutMapping()
    //   @CrossOrigin(origins = "*",methods = {RequestMethod.PUT})
     public ResponseEntity<Personnel> ajouterPersonnel(@RequestBody Personnel personnel) {
        this.personnelService.savePersonnels(personnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personnel);
    }

}
