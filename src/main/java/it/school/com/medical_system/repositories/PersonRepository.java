package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    //Optional<PersonEntity> findById(int id);
     List<PersonEntity> findByLastName(String name);
}
