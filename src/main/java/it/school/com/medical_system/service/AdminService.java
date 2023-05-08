package it.school.com.medical_system.service;

import it.school.com.medical_system.entities.AdminEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
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

        //todo implement this if you want , is not used for the moment
    public void delete(String firstName, String lastName) {
        this.adminRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }
    public void delete(int id) throws InexistentResourceException{
        this.adminRepository.findById(id).orElseThrow(()->new InexistentResourceException("This admin does not exist in the data base"));
        this.adminRepository.deleteById(id);
    }
}
