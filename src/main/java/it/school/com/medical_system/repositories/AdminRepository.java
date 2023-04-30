package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity,Integer> {
}
