package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
    @Query("select a from Admin a where a.email= :email")
    public Admin findAdminByEmail(String email);
    
}
