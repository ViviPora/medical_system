package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.MedicationEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.entities.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PrescriptionRepository extends CrudRepository<PrescriptionEntity, Integer> {


    PrescriptionEntity findByPatientEntityAndMedicationEntity(Optional<PatientEntity> byId, Optional<MedicationEntity> byId1);
}
