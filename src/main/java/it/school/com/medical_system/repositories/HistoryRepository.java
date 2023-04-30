package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.HistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<HistoryEntity,Integer> {
    HistoryEntity findByMedicalHistory(String code);
}
