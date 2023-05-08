package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.NurseDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.NurseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class NurseService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private NurseRepository nurseRepository;

    @Transactional
    public NurseEntity add(NurseDTO nurseDTO) {
        log.info("Add new address");
        AddressEntity address = new AddressEntity();
        address.setCountry(nurseDTO.getCountry());
        address.setCity(nurseDTO.getCity());
        address.setStreet(nurseDTO.getStreet());
        address.setAddress(nurseDTO.getAddress());
        log.info("Saving address to database");
        AddressEntity addressEntity = addressRepository.save(address);
        log.info("Address successfully saved");
        log.info("Add new nurse");
        NurseEntity nurse = new NurseEntity();
        nurse.setFirstName(nurseDTO.getFirstName());
        nurse.setLastName(nurseDTO.getLastName());
        nurse.setBirthDate(nurseDTO.getBirtDate());
        nurse.setEmail(nurseDTO.getEmail());
        nurse.setPhone(nurseDTO.getPhone());
        nurse.setAddress(addressEntity);
        nurse.setGender(nurseDTO.getGender());
        nurse.setExperience(nurseDTO.getExperience());
        nurse.setDegreeNumber(nurseDTO.getDegreeNumber());
        log.info("Saving nurse to database");
        NurseEntity nurseEntity = nurseRepository.save(nurse);
        log.info("Nurse successfully saved");
        return nurseEntity;
    }
       public Iterable<NurseEntity> findAll(){
           log.info("Find all nurses"); return this.nurseRepository.findAll();
            }
    public void delete(int id) throws InexistentResourceException{
        log.info("Search for the nurse you want to delete by id");
        this.nurseRepository.findById(id).orElseThrow(() -> new InexistentResourceException("Nurse does not exist"));
        log.info("The nurse to delete has been found and will be deleted ");
        this.nurseRepository.deleteById(id);
        log.info("The nurse has been successfully deleted");
    }
}
