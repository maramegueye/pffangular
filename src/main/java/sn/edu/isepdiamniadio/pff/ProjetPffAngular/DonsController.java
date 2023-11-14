package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dons")
public class DonsController {
    @Autowired
    private DonsService donationService;

    @GetMapping
    
    public List<Dons> getDons(){
        return this.donationService.getDons();
    } 
    @GetMapping("/{id}")
    public Dons FindDons(@PathVariable Integer id){
        Optional <Dons> app = this.donationService.FindDons(id);
        return app.orElse(null);
    }
    
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDons(@PathVariable Integer id) {
       Dons dons = FindDons(id);
       if (dons==null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la demande numero " +id+" n'exite pas");
        
       }
       this.donationService.deleteDons(id);
       return ResponseEntity.status(HttpStatus.OK).body("suppression  reussi de la demande  numero"+id);
    }

    @PutMapping()
     @CrossOrigin(origins = "*",methods = {RequestMethod.PUT})
    public ResponseEntity<Dons> ajouterDons(@RequestBody Dons dons){
        this.donationService.saveDons(dons);
        return ResponseEntity.status(HttpStatus.CREATED).body(dons);
    }


    
}
