package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.PatientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NurseRepository extends CrudRepository<NurseEntity, Integer> {

    NurseEntity findByLastName(String lastname);

    Optional<NurseEntity> findByLastNameAndFirstName(String lastName, String firstName);
    boolean existsByLastNameAndFirstName(String lastName, String firstName);

    @Query("SELECT n.address FROM NurseEntity n WHERE n.id=:id")
    Optional<AddressEntity> findAddress(int id);
}
