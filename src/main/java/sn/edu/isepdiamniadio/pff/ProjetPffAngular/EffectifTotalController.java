package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/effectifs")
public class EffectifTotalController {

    @Autowired
    private EffectifTotalService effectifTotalService;

    @GetMapping
    public List<EffectifTotal> getEffectifTotals() {
        return this.effectifTotalService.getEffectifTotals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EffectifTotal> findEffectifTotal(@PathVariable Integer id) {
        Optional<EffectifTotal> effectifTotal = this.effectifTotalService.findEffectifTotal(id);
        return effectifTotal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEffectifTotal(@PathVariable Integer id) {
        EffectifTotal effectifTotal = this.effectifTotalService.findEffectifTotal(id).orElse(null);
        if (effectifTotal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La demande numéro " + id + " n'existe pas");
        }

        this.effectifTotalService.deleteEffectifTotal(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Suppression réussie de la demande numéro " + id);
    }

    @PutMapping()
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public ResponseEntity<String> ajouterform(@RequestBody EffectifTotal effectifTotal) {
    // Ensure that effectifTotalService is not null before invoking methods
    if (effectifTotalService != null) {
        effectifTotalService.saveEffectifTotal(effectifTotal);
        return ResponseEntity.status(HttpStatus.OK).body("Enregistrement réussi");
    } else {
        // Handle the case where effectifTotalService is null
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Service non disponible");
    }
}

}
