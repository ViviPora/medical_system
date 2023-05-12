package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String email);
    Boolean existsByUsername(String username);

}
