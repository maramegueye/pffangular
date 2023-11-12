package sn.edu.isepdiamniadio.pff.ProjetPffAngular;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;
    public List<DemandeAdoption> getDemandeFormulaires(){
        return this.demandeRepository.findAll();
    }
    public Optional<DemandeAdoption> FindDemandeFormulaire(Integer id){
        return this.demandeRepository.findById(id);
    }
    public void saveDemandeFormulaire(DemandeAdoption demandeFormulaire){
        this.demandeRepository.save(demandeFormulaire);
    }
    public void deleteDemandeFormulaire(Integer id){
        this.demandeRepository.deleteById(id);
    }

    
}
