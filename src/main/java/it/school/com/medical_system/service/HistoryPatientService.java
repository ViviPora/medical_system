package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.HistoryPatientDTO;
import it.school.com.medical_system.entities.HistoryEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.repositories.HistoryRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HistoryPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HistoryRepository historyRepository;

    //todo Inexitent Resource Exception
    //todo Optional
    @Transactional
    public void addHistory(HistoryPatientDTO historyPatientDTO) {
        PatientEntity patient = patientRepository.findByLastNameAndFirstName(historyPatientDTO.getLastName(), historyPatientDTO.getFirstName());
        HistoryEntity history = historyRepository.findByMedicalHistory(historyPatientDTO.getMedicalHistory());
        patient.getHistoryEntity().add(history);
        history.getPatientEntities().add(patient);

        historyRepository.save(history);
    }
    //TODO nu cred ca e OK
        public Iterable<HistoryEntity> findAll(){
            return this.historyRepository.findAll();
        }
}
