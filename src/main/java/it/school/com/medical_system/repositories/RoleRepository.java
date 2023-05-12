package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.RoleEntity;
import it.school.com.medical_system.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(Role name);

}
