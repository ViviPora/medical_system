package it.school.com.medical_system.service;

import it.school.com.medical_system.entities.AdminEntity;
import it.school.com.medical_system.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity add(AdminEntity adminEntity){
        AdminEntity admin = new AdminEntity();
        admin.setFirstName(adminEntity.getFirstName());
        admin.setLastName(adminEntity.getLastName());
        admin.setEmail(adminEntity.getEmail());
        admin.setPassword(adminEntity.getPassword());
        admin.setCode(adminEntity.getCode());

        adminRepository.save(admin);
        return admin;
    }

        public Iterable<AdminEntity> findAll(){
            return this.adminRepository.findAll();
        }
}
