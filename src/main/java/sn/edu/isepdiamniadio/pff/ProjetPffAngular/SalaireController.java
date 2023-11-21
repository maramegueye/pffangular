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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/salaires")
public class SalaireController {

    @Autowired
    private SalaireService salaireService;

    @GetMapping
    public List<Salaire> getSalaires() {
        return this.salaireService.getSalaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salaire> findSalaire(@PathVariable Integer id) {
        Optional<Salaire> salaire = this.salaireService.findSalaire(id);
        return salaire.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalaire(@PathVariable Integer id) {
        Optional<Salaire> salaire = this.salaireService.findSalaire(id);
        if (salaire.isPresent()) {
            this.salaireService.deleteSalaire(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppression réussie pour la demande numéro " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La demande numéro " + id + " n'existe pas");
        }
    }

    @PostMapping
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public ResponseEntity<Salaire> createSalaire(@RequestBody Salaire salaire) {
        Salaire savedSalaire = salaireService.saveSalaire(salaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalaire);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public ResponseEntity<Salaire> updateSalaire(@PathVariable Integer id, @RequestBody Salaire salaire) {
        Optional<Salaire> existingSalaire = salaireService.findSalaire(id);
        
if (existingSalaire.isPresent()) {
            salaire.setId(id);
            Salaire updatedSalaire = salaireService.saveSalaire(salaire);
            return ResponseEntity.ok().body(updatedSalaire);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}