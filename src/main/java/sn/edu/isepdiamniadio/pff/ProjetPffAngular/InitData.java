package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitData implements CommandLineRunner {

    private final AdminRepository adminRepository;

    public InitData(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional // Ensure the transactional behavior for the method
    public void run(String... args) {
        System.out.println("Démarrage de l'application...");
        if (adminRepository.count() == 0) {
            Admin admin = new Admin();
            admin.setEmail("admin@example.com"); // Set a non-null email value
            admin.setPassword(IsepUtil.sha512( "titi"));
            adminRepository.save(admin);
        }
    }
}
