package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demandes")
public class DemandeController {
    
    @Autowired
    private  DemandeService demandeService ;

    @GetMapping
     @CrossOrigin("http://localhost:4200/")
    public List<DemandeAdoption> getDemandeFormulaires(){
        return this.demandeService.getDemandeFormulaires();
    }

    @GetMapping("/{id}")
    public DemandeAdoption FindDemandeFormulaire(@PathVariable Integer id){
        Optional <DemandeAdoption> app = this.demandeService.FindDemandeFormulaire(id);
        return app.orElse(null);
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<Object> deleteDemandeFormulaire(@PathVariable Integer id){
        DemandeAdoption demandeFormulaire = FindDemandeFormulaire(id);
        if (demandeFormulaire==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la demande numero " +id+" n'exite pas" );   
        }

        this.demandeService.deleteDemandeFormulaire(id);
        return ResponseEntity.status(HttpStatus.OK).body("suppression  reussi de la demande  numero " +id);
    }

    @PutMapping()
    public ResponseEntity<DemandeAdoption> ajouterform(@RequestBody DemandeAdoption demandeFormulaire){
        this.demandeService.saveDemandeFormulaire(demandeFormulaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeFormulaire);

    }

    
}
