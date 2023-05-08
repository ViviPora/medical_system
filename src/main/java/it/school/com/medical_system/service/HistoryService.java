package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.HistoryDTO;
import it.school.com.medical_system.entities.HistoryEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public HistoryEntity add(HistoryDTO historyDTO){
        log.info("Add new history");
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setMedicalHistory(historyDTO.getHistory());
        log.info("Saving history to database");
        HistoryEntity history = historyRepository.save(historyEntity);
        log.info("History successfully saved");
        return history;
    }

    //TODO ??? E bine?
    public Iterable<HistoryEntity> findAll(){
        log.info("Find all history");
        return this.historyRepository.findAll();
    }
    public void delete(int id) throws InexistentResourceException{
        log.info("Search for the history you want to delete by id");
        this.historyRepository.findById(id).orElseThrow(() -> new InexistentResourceException("Nurse does not exist"));
        log.info("The history to delete has been found and will be deleted ");
        this.historyRepository.deleteById(id);
        log.info("The history has been successfully deleted");

    }

}
