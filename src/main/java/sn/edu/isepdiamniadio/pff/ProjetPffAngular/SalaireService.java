package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaireService {

    @Autowired
    
    
private SalaireRepository salaireRepository;

    public List<Salaire> getSalaires() {
        return salaireRepository.findAll();
    }

    public Optional<Salaire> findSalaire(Integer id) {
        return salaireRepository.findById(id);
    }

    public void deleteSalaire(Integer id) {
        salaireRepository.deleteById(id);
    } 
        
public Salaire saveSalaire(Salaire salaire) {
        return salaireRepository.save(salaire);
    }
}