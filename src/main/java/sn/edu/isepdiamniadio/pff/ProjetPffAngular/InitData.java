package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitData implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final EnvoyerEmailService envoyerEmailService;

    public InitData(AdminRepository adminRepository, EnvoyerEmailService eenvoyerEmailService) {
        this.adminRepository = adminRepository;
        this.envoyerEmailService = eenvoyerEmailService;
    }

    @Override
    @Transactional // Ensure the transactional behavior for the method
    public void run(String... args) {
        System.out.println("Démarrage de l'application...");

        try {
            envoyerEmailService.sendEmail("gueyemarame47@gmail.com","demerage du serveurs","le serveurs a ete demarer "+new Date());
       
        } catch (Exception e) {
            System.out.println("erreurs envoye email");
            e.printStackTrace();
        }
        if (adminRepository.count() == 0) {
            Admin admin = new Admin();
            admin.setEmail("admin@example.com"); // Set a non-null email value
            admin.setPassword(IsepUtil.sha512( "titi"));
            adminRepository.save(admin);
        }
    }
}
