package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonnelService {

    @Autowired
    
    
private PersonnelRepository personnelRepository;

    public List<Personnel> getPersonnels() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> findPersonnel(Integer id) {
        return personnelRepository.findById(id);
    }

    public void deletePersonnel(Integer id) {
        personnelRepository.deleteById(id);
    } 
        
public Personnel savePersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }
}
