package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class EnfantService {

    @Autowired
    private EnfantRepository enfantRepository;

    public List<Enfant> getEnfants() {
        return this.enfantRepository.findAll();
    }

    public Optional<Enfant> findById(Integer id) {
        return this.enfantRepository.findById(id);
    }

    public void deleteById(Integer id) {
        this.enfantRepository.deleteById(id);
    }

    public void save(Enfant enfant) {
        this.enfantRepository.save(enfant);
    }

    public boolean store(MultipartFile file, Enfant enfant) {
        boolean status = false;
        try {
            byte[] photo = file.getBytes();
            enfant.updatePhoto(photo, enfant);
            save(enfant); // Sauvegarde de l'objet Enfant avec la photo mise à jour
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            // Vous pouvez également logger l'exception ou la remonter pour une gestion plus poussée
        }
        return status;
    }

   
}
