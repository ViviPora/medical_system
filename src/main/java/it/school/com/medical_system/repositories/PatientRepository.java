package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PatientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
    PatientEntity findByLastName(String lastname);

    Optional<PatientEntity> findByLastNameAndFirstName(String lastName, String firstName);

    @Query("SELECT p.address FROM PersonEntity p WHERE p.id=:id")
    Optional<AddressEntity> findAddress(int id);
}