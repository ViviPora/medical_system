package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;


public interface PrescriptionRepository extends CrudRepository<PrescriptionEntity, Integer> {
}
