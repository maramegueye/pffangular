package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adopteurs")
@CrossOrigin(origins = "*")  // Vous pouvez définir l'origine globale au niveau du contrôleur
public class AdopteurController {

    @Autowired
    private AdopteurService adopteurService;

    @GetMapping
    public List<Adopteur> getAdopteurs() {
        return adopteurService.getAdopteurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adopteur> findAdopteur(@PathVariable Integer id) {
        Optional<Adopteur> adopteur = adopteurService.findAdopteur(id);
        return adopteur.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdopteur(@PathVariable Integer id) {
        Optional<Adopteur> adopteur = adopteurService.findAdopteur(id);
        if (adopteur.isPresent()) {
            adopteurService.deleteAdopteur(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppression réussie pour la demande numéro " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La demande numéro " + id + " n'existe pas");
        }
    }

    @PostMapping  // Utilisez @PostMapping au lieu de @PutMapping pour créer une nouvelle ressource
    public ResponseEntity<Adopteur> createAdopteur(@RequestBody Adopteur adopteur) {
        Adopteur savedAdopteur = adopteurService.saveAdopteur(adopteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdopteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adopteur> updateAdopteur(@PathVariable Integer id, @RequestBody Adopteur adopteur) {
        Optional<Adopteur> existingAdopteur = adopteurService.findAdopteur(id);

        if (existingAdopteur.isPresent()) {
            adopteur.setId(id);
            Adopteur updatedAdopteur = adopteurService.saveAdopteur(adopteur);
            return ResponseEntity.ok().body(updatedAdopteur);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
