package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.ProceduresEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProceduresRepository extends CrudRepository<ProceduresEntity, Integer> {
    Optional <ProceduresEntity> findByName(String procedureName);

}
