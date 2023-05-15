package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.HistoryPatientDTO;
import it.school.com.medical_system.entities.HistoryEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.HistoryRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class HistoryPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HistoryRepository historyRepository;

    @Transactional
    public void addHistory(HistoryPatientDTO historyPatientDTO) throws InexistentResourceException {
        log.info("Add new patient history");
        log.info("Check if patient exist");
        Optional<PatientEntity> patientOptional = patientRepository.findByLastNameAndFirstName(historyPatientDTO.getLastName(), historyPatientDTO.getFirstName());
        if (!patientOptional.isPresent()) {
            throw new InexistentResourceException("Patient does not exist", historyPatientDTO.getLastName(), historyPatientDTO.getFirstName());
        }
        log.info("Patient found");
        log.info("Check if history exist in db");
        Optional<HistoryEntity> historyOptional = historyRepository.findByMedicalHistory(historyPatientDTO.getMedicalHistory());
        if (!historyOptional.isPresent()) {
            throw new InexistentResourceException("Can not found medical history", historyPatientDTO.getMedicalHistory());
        }
        log.info("History found");
        log.info("Get history");
        HistoryEntity history = historyOptional.get();
        log.info("Get patient");
        PatientEntity patient = patientOptional.get();
        log.info("Adding the patient history");
        patient.getHistoryEntity().add(history);
        history.getPatientEntities().add(patient);
        log.info("Saving the patient history");
        historyRepository.save(history);
        log.info("The patient history has been successfully added");
    }

    //TODO nu cred ca e OK
    // todo - > cred ca trebuie un historyPatient repository
    //todo nu e finalizat delete-ul -> ai nevoie de exceptie si nu e corect ca tu cauti doar history  nu history patient
    public Iterable<HistoryEntity> findAll() {
        log.info("find all patient history");
        return this.historyRepository.findAll();
    }

    public void delete(int id) {
        this.historyRepository.deleteById(id);
    }
}
