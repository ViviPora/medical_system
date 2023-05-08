package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PatientProceduresDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.PatientProceduresRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.ProceduresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PatientProceduresService {
    @Autowired
    PatientProceduresRepository patientProceduresRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ProceduresRepository proceduresRepository;

    public PatientProceduresEntity add(PatientProceduresDTO patientProceduresDTO) throws InexistentResourceException {
        log.info("Add new patient procedures");
        PatientProceduresEntity patientProceduresEntity = new PatientProceduresEntity();

        Optional<ProceduresEntity> proceduresOptional = proceduresRepository.findByName(patientProceduresDTO.getProcedureName());
        Optional<PatientEntity> patientOptional = patientRepository.findByLastNameAndFirstName(patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        Optional<DoctorEntity> doctorOptional = doctorRepository.findByLastNameAndFirstName(patientProceduresDTO.getDoctorLastName(), patientProceduresDTO.getDoctorFirstName());
        log.info("Search for procedure");
        if (!proceduresOptional.isPresent()) {
            throw new InexistentResourceException("This procedure does not exist!", patientProceduresDTO.getProcedureName());
        }
        log.info("Procedure exist");
        log.info("Search for patient");
        if (!patientOptional.isPresent()) {
            throw new InexistentResourceException("This patient does not exist!", patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        }
        log.info("Patient exist");
        log.info("Search for doctor");
        if (!doctorOptional.isPresent()) {
            throw new InexistentResourceException("This doctor does not exist!", patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        }
        log.info("Patient exist");
        log.info("Getting procedures, patient, doctor");
        ProceduresEntity procedures = proceduresOptional.get();
        PatientEntity patient = patientOptional.get();
        DoctorEntity doctor = doctorOptional.get();

        int patientId = patient.getId();
        int doctorId = doctor.getId();
        int proceduresId = procedures.getId();
        log.info("New PK for patient procedures");
        PatientProceduresPK patientProceduresPK = new PatientProceduresPK(patientId, doctorId, proceduresId);
        patientProceduresEntity.setId(patientProceduresPK);
        patientProceduresEntity.setDoctor(doctor);
        patientProceduresEntity.setPatient(patient);
        patientProceduresEntity.setProcedures(procedures);
        patientProceduresEntity.setDescription(patientProceduresDTO.getDescription());
        log.info("Saving patient procedures");
        return patientProceduresRepository.save(patientProceduresEntity);
    }

    public Iterable<PatientProceduresEntity> findAll() {
        log.info("Find all patient procedures");
        return this.patientProceduresRepository.findAll();
    }

    //TODO -> PK -> vezi dupa ce dai parametru dai delete
//    public void delete(int id) {
//        this.patientProceduresRepository.deleteById(id);
//    }
}
