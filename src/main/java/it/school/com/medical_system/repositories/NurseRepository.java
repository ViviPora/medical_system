package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends CrudRepository<NurseEntity, Integer> {

    NurseEntity findByLastName(String lastname);
    NurseEntity findByLastNameAndFirstName(String lastName, String firstName);

}
