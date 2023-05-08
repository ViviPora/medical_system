package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PatientProceduresDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.PatientProceduresRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.ProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        PatientProceduresEntity patientProceduresEntity = new PatientProceduresEntity();
        Optional<ProceduresEntity> proceduresOptional = proceduresRepository.findByName(patientProceduresDTO.getProcedureName());
        Optional<PatientEntity> patientOptional = patientRepository.findByLastNameAndFirstName(patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        Optional<DoctorEntity> doctorOptional = doctorRepository.findByLastNameAndFirstName(patientProceduresDTO.getDoctorLastName(), patientProceduresDTO.getDoctorFirstName());
        if (!proceduresOptional.isPresent()) {
            throw new InexistentResourceException("This procedure does not exist!", patientProceduresDTO.getProcedureName());
        }
        if (!patientOptional.isPresent()) {
            throw new InexistentResourceException("This patient does not exist!", patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        }
        if (!doctorOptional.isPresent()) {
            throw new InexistentResourceException("This doctor does not exist!", patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName());
        }
        ProceduresEntity procedures = proceduresOptional.get();
        PatientEntity patient = patientOptional.get();
        DoctorEntity doctor = doctorOptional.get();

        int patientId = patient.getId();
        int doctorId = doctor.getId();
        int proceduresId = procedures.getId();
        PatientProceduresPK patientProceduresPK = new PatientProceduresPK(patientId, doctorId, proceduresId);
        patientProceduresEntity.setId(patientProceduresPK);
        patientProceduresEntity.setDoctor(doctor);
        patientProceduresEntity.setPatient(patient);
        patientProceduresEntity.setProcedures(procedures);
        patientProceduresEntity.setDescription(patientProceduresDTO.getDescription());
        return patientProceduresRepository.save(patientProceduresEntity);
    }

    public Iterable<PatientProceduresEntity> findAll() {
        return this.patientProceduresRepository.findAll();
    }

    //TODO -> PK -> vezi dupa ce dai parametru dai delete
//    public void delete(int id) {
//        this.patientProceduresRepository.deleteById(id);
//    }
}
