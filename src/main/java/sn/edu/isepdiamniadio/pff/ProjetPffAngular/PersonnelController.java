package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personnels")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping
    public List<Personnel> getPersonnels() {
        return this.personnelService.getPersonnels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personnel> findPersonnel(@PathVariable Integer id) {
        Optional<Personnel> personnel = this.personnelService.findPersonnel(id);
        return personnel.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonnel(@PathVariable Integer id) {
        Optional<Personnel> personnel = this.personnelService.findPersonnel(id);
        if (personnel.isPresent()) {
            this.personnelService.deletePersonnel(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppression réussie pour la demande numéro " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La demande numéro " + id + " n'existe pas");
        }
    }

    @PostMapping
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public ResponseEntity<Personnel> createPersonnel(@RequestBody Personnel personnel) {
        Personnel savedPersonnel = personnelService.savePersonnel(personnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonnel);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public ResponseEntity<Personnel> updatePersonnel(@PathVariable Integer id, @RequestBody Personnel personnel) {
        Optional<Personnel> existingPersonnel = personnelService.findPersonnel(id);
        
if (existingPersonnel.isPresent()) {
            personnel.setId(id);
            Personnel updatedPersonnel = personnelService.savePersonnel(personnel);
            return ResponseEntity.ok().body(updatedPersonnel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
