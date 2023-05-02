package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.HistoryDTO;
import it.school.com.medical_system.entities.HistoryEntity;
import it.school.com.medical_system.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public HistoryEntity add(HistoryDTO historyDTO){
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setMedicalHistory(historyDTO.getHistory());
        return historyRepository.save(historyEntity);
    }

    //TODO ??? E bine?
    public Iterable<HistoryEntity> findAll(){
        return this.historyRepository.findAll();
    }
    public void delete(int id) {
        this.historyRepository.deleteById(id);
    }

}
