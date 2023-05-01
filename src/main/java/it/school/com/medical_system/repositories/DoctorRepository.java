package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.NurseEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> {

    DoctorEntity findById(int id);
    DoctorEntity findByLastName(String lastname);
    DoctorEntity findByLastNameAndFirstName(String lastName, String firstName);

}
