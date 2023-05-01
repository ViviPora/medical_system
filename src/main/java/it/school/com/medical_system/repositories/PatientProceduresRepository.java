package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.OnCallEntity;
import it.school.com.medical_system.entities.PatientProceduresEntity;
import it.school.com.medical_system.entities.PatientProceduresPK;
import org.springframework.data.repository.CrudRepository;

public interface PatientProceduresRepository extends CrudRepository<PatientProceduresEntity, PatientProceduresPK> {
}
