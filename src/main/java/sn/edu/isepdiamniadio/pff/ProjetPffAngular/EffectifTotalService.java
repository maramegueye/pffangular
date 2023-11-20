package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EffectifTotalService {

    @Autowired
    private EffectifTotalRepository effectifTotalRepository;

    public List<EffectifTotal> getEffectifTotals() {
        return effectifTotalRepository.findAll();
    }

    public Optional<EffectifTotal> findEffectifTotal(Integer id) {
        return effectifTotalRepository.findById(id);
    }

    public void saveEffectifTotal(EffectifTotal effectifTotal) {
        effectifTotalRepository.save(effectifTotal);
    }

    public void deleteEffectifTotal(Integer id) {
        effectifTotalRepository.deleteById(id);
    }
}
