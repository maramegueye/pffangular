package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonnelService {
    

    @Autowired
    private PersonnelRepository personnelsRepository;
    public List<Personnel> getPersonnels(){
        return this.personnelsRepository.findAll();
    }
    public Optional<Personnel> FindPersonnels(Integer id){
        return this.personnelsRepository.findById(id);
    }
    public void savePersonnels(Personnel personnels){
        this.personnelsRepository.save(personnels);
    }
    public void deletePersonnels(Integer id){
        this.personnelsRepository.deleteById(id);
    }
}
