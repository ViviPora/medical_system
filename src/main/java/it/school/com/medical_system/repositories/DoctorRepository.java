package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.NurseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> {

    Optional<DoctorEntity> findById(int id);

    DoctorEntity findByLastName(String lastname);

    Optional<DoctorEntity> findByLastNameAndFirstName(String lastName, String firstName);

    boolean existsByLastNameAndFirstName(String lastname, String firstname);

    List<DoctorEntity> findByExperienceGreaterThan(int experience);

    List<DoctorEntity> findBySpecialization(String specialization);

    @Query("SELECT d.address FROM DoctorEntity d WHERE d.id=:id")
    Optional<AddressEntity> findAddress(int id);
}
