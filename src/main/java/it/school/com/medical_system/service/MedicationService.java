package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.MedicationDTO;
import it.school.com.medical_system.entities.MedicationEntity;
import it.school.com.medical_system.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;

    public MedicationEntity add(MedicationDTO medicationDTO) {
        MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setName(medicationDTO.getName());
        medicationEntity.setBrand(medicationDTO.getBrand());
        medicationEntity.setDescription(medicationDTO.getDescription());
        return medicationRepository.save(medicationEntity);
    }
       public Iterable<MedicationEntity> findAll(){
                return this.medicationRepository.findAll();
            }
    public void delete(int id) {
        this.medicationRepository.deleteById(id);
    }
}
