package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NurseRepository extends CrudRepository<NurseEntity, Integer> {

    NurseEntity findByLastName(String lastname);
    //Optional<NurseEntity> findById(int id);
    Optional<NurseEntity> findByLastNameAndFirstName(String lastName, String firstName);

}
