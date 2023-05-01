package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.ProceduresEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProceduresRepository extends CrudRepository<ProceduresEntity, Integer> {
    ProceduresEntity findByName(String procedureName);
}
