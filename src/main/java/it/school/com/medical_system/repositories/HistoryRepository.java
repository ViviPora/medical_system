package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.HistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HistoryRepository extends CrudRepository<HistoryEntity,Integer> {
    Optional <HistoryEntity> findByMedicalHistory(String code);
  //  Optional<HistoryEntity> findById(int id);
}
