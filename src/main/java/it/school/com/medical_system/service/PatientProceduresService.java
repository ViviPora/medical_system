package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PatientProceduresDTO;
import it.school.com.medical_system.entities.PatientProceduresEntity;
import it.school.com.medical_system.entities.PatientProceduresPK;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.PatientProceduresRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.ProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PatientProceduresEntity add(PatientProceduresDTO patientProceduresDTO) {
        PatientProceduresEntity patientProceduresEntity = new PatientProceduresEntity();
        int patient = patientRepository.findByLastNameAndFirstName(patientProceduresDTO.getPatientLastName(), patientProceduresDTO.getPatientFirstName()).getId();
        int doctor = doctorRepository.findByLastNameAndFirstName(patientProceduresDTO.getDoctorLastName(),
                patientProceduresDTO.getDoctorFirstName()).getId();
        int procedures = proceduresRepository.findByName(patientProceduresDTO.getProcedureName()).getId();
        PatientProceduresPK patientProceduresPK = new PatientProceduresPK(patient, doctor, procedures);
        patientProceduresEntity.setId(patientProceduresPK);
        patientProceduresEntity.setDoctor
                (doctorRepository.findByLastNameAndFirstName(patientProceduresDTO.getDoctorLastName(),
                        patientProceduresDTO.getDoctorFirstName()));
        patientProceduresEntity.setPatient
                (patientRepository.findByLastNameAndFirstName(patientProceduresDTO.getPatientLastName(),
                        patientProceduresDTO.getPatientFirstName()));
        patientProceduresEntity.setProcedures
                (proceduresRepository.findByName(patientProceduresDTO.getProcedureName()));

        patientProceduresEntity.setDescription(patientProceduresDTO.getDescription());
        return patientProceduresRepository.save(patientProceduresEntity);
    }
       public Iterable<PatientProceduresEntity> findAll(){
                return this.patientProceduresRepository.findAll();
            }
//    public void delete(int id) {
//        this.patientProceduresRepository.deleteById(id);
//    }
}
