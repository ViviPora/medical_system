package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Integer> {

}
