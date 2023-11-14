package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EffectifTotalService {


   @Autowired
    private EffectifTotalRepository effectifTotalRepository;

    public List<EffectifTotal> gEffectifTotals(){
        return this.effectifTotalRepository.findAll();
    }
    public Optional<EffectifTotal> FindEffectifTotal(Integer id){
        return this.effectifTotalRepository.findById(id);
    }
    public void saveEffectifTotal(EffectifTotal effectifTotal){
        this.effectifTotalRepository.save(effectifTotal);
    }
    public void deleteEffectifTotal(Integer id){
        this.effectifTotalRepository.deleteById(id);
    
}
    public List<EffectifTotal> getEffectifTotals() {
        return null;
    }
}