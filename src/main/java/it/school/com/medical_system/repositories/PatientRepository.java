package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
    PatientEntity findById(int id);
    PatientEntity findByLastName(String lastname);


}
