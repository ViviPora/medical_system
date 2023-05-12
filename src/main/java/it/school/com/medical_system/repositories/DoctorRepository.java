package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.NurseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> {

    Optional<DoctorEntity> findById(int id);
    DoctorEntity findByLastName(String lastname);
    Optional <DoctorEntity> findByLastNameAndFirstName(String lastName, String firstName);

   // List<DoctorEntity> findByExperienceAndSpecialization(int experience, String specialization);
   // List<DoctorEntity> findByExperienceGreaterThanAndSpecialization(int experience, String specialization);
    List<DoctorEntity> findByExperienceGreaterThan(int experience);
    List<DoctorEntity> findBySpecialization(String specialization);
}
