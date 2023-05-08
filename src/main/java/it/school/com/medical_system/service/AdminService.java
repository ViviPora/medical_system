package it.school.com.medical_system.service;

import it.school.com.medical_system.entities.AdminEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity add(AdminEntity adminEntity){
        log.info("Add new admin");

        AdminEntity admin = new AdminEntity();
        admin.setFirstName(adminEntity.getFirstName());
        admin.setLastName(adminEntity.getLastName());
        admin.setEmail(adminEntity.getEmail());
        admin.setPassword(adminEntity.getPassword());
        admin.setCode(adminEntity.getCode());
        log.info("Saving admin to database");
        adminRepository.save(admin);
        log.info("Admin successfully saved");
        return admin;
    }

        public Iterable<AdminEntity> findAll(){
            log.info("Find all admins");
            return this.adminRepository.findAll();
        }

        //todo implement this if you want , is not used for the moment
    public void delete(String firstName, String lastName) {
        this.adminRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }
    public void delete(int id) throws InexistentResourceException{
        log.info("Search for the admin you want to delete by id");
        this.adminRepository.findById(id).orElseThrow(()->new InexistentResourceException("This admin does not exist in the data base"));
        log.info("The admin to delete has been found and will be deleted ");
        this.adminRepository.deleteById(id);
        log.info("The admin has been successfully deleted");
    }
}
