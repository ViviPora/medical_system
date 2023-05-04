package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.HistoryPatientDTO;
import it.school.com.medical_system.entities.HistoryEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
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
    public void addHistory(HistoryPatientDTO historyPatientDTO) throws InexistentResourceException {
        Optional<PatientEntity> patientOptional = patientRepository.findByLastNameAndFirstName(historyPatientDTO.getLastName(), historyPatientDTO.getFirstName());
        if (!patientOptional.isPresent()){
            throw new InexistentResourceException("Patient does not exist", historyPatientDTO.getLastName(), historyPatientDTO.getFirstName());
        }
        Optional<HistoryEntity> historyOptional = historyRepository.findByMedicalHistory(historyPatientDTO.getMedicalHistory());
        if (!historyOptional.isPresent()) {
            throw new InexistentResourceException("Can not found medical history", historyPatientDTO.getMedicalHistory());
        }
        HistoryEntity history = historyOptional.get();
        PatientEntity patient = patientOptional.get();

        patient.getHistoryEntity().add(history);
        history.getPatientEntities().add(patient);

        historyRepository.save(history);
    }

    //TODO nu cred ca e OK
    public Iterable<HistoryEntity> findAll() {
        return this.historyRepository.findAll();
    }

    public void delete(int id) {
        this.historyRepository.deleteById(id);
    }
}
