package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.MedicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicationRepository extends CrudRepository<MedicationEntity, Integer> {

    Optional<MedicationEntity> findByName(String medicationName);
}
