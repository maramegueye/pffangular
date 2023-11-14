package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/api/v1/effectifs")
public class EffectifTotalController {

    private EffectifTotalService effectifTotalService;
    @GetMapping
    @CrossOrigin("http://localhost:4200/")
    public List<EffectifTotal> getEffectifTotals(){
        return this.effectifTotalService.getEffectifTotals();
    }

    @GetMapping("/{id}")
    public EffectifTotal FindEffectifTotal(@PathVariable Integer id){
        Optional <EffectifTotal> app = this.effectifTotalService.FindEffectifTotal(id);
        return app.orElse(null);
    }
      @DeleteMapping("/{id}") 
    public ResponseEntity<Object> deleteEffectifTotal(@PathVariable Integer id){
        EffectifTotal effectifTotal =  FindEffectifTotal(id);
        if (effectifTotal==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la demande numero " +id+" n'exite pas" );   
        }

        this.effectifTotalService.deleteEffectifTotal(id);
        return ResponseEntity.status(HttpStatus.OK).body("suppression  reussi de la demande  numero " +id);
    }

    @PutMapping()
     @CrossOrigin(origins = "*",methods = {RequestMethod.PUT})
    public ResponseEntity<EffectifTotal> ajouterform(@RequestBody EffectifTotal effectifTotal){
        this.effectifTotalService.saveEffectifTotal(effectifTotal);
        return ResponseEntity.status(HttpStatus.CREATED).body(effectifTotal);

    }

}
