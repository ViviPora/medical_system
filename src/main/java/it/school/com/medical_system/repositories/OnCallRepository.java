package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.OnCallEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OnCallRepository extends CrudRepository<OnCallEntity, Integer> {
    //Optional<OnCallEntity> findById(int id);
}
