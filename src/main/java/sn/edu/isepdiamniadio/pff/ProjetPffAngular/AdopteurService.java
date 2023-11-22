package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdopteurService {

     @Autowired
    private AdopteurRepository adopteurRepository;

    public List<Adopteur> getAdopteurs() {
        return adopteurRepository.findAll();
    }

    public Optional<Adopteur> findAdopteur(Integer id) {
        return adopteurRepository.findById(id);
    }

    public void deleteAdopteur(Integer id) {
        adopteurRepository.deleteById(id);
    } 
        
public Adopteur saveAdopteur(Adopteur adopteur) {
        return adopteurRepository.save(adopteur);
    }
    
}
