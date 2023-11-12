package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dons")
public class DonsController {
    @Autowired
    private DonsService donsService;

    @GetMapping
    public List<Dons> getDons(){
        return this.donsService.getDons();
    } 
    @GetMapping("/{id}")
    public ResponseEntity<Dons> findDons(@PathVariable Integer id) {
        Optional<Dons> dons = donsService.FindDons(id);
        return dons.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDons(@PathVariable Integer id) {
        if (donsService.FindDons(id).isPresent()) {
            donsService.deleteDons(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<Dons> ajouterDons(@RequestBody Dons dons){
        this.donsService.saveDons(dons);
        return ResponseEntity.status(HttpStatus.CREATED).body(dons);
    }


    
}
