package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonsService {
    @Autowired
    private DonsRepository donsRepository;
    public List<Dons> getDons(){
        return this.donsRepository.findAll();
    }
    public Optional<Dons> FindDons(Integer id){
        return this.donsRepository.findById(id);
    }
    public void saveDons(Dons dons){
        this.donsRepository.save(dons);
    }
    public void deleteDons(Integer id){
        this.donsRepository.deleteById(id);
    }
    
}
