package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.MedicationDTO;
import it.school.com.medical_system.entities.MedicationEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.MedicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;

    public MedicationEntity add(MedicationDTO medicationDTO) {
        log.info("Add new medication");
        MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setName(medicationDTO.getName());
        medicationEntity.setBrand(medicationDTO.getBrand());
        medicationEntity.setDescription(medicationDTO.getDescription());
        log.info("Saving medication to database");
        return medicationRepository.save(medicationEntity);
    }
       public Iterable<MedicationEntity> findAll(){
           log.info("Find all medications");
           return this.medicationRepository.findAll();
            }
    public void delete(int id) throws InexistentResourceException{
        log.info("Search for the medication you want to delete by id");
        this.medicationRepository.findById(id).orElseThrow(() -> new InexistentResourceException("This medication does not exist"));
        log.info("The medication to delete has been found and will be deleted ");
        this.medicationRepository.deleteById(id);
        log.info("The medication has been successfully deleted");
    }
}
