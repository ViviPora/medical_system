package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PrescriptionDTO;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PrescriptionEntity;
import it.school.com.medical_system.entities.PrescriptionPK;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.MedicationRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    PatientRepository patientRepository;
//ToDO - trebuie sa introduci in PatientDTO nume, prenume -acum e cu ID si trebuie refacut si service
    public PrescriptionEntity add(PrescriptionDTO prescriptionDTO) {
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        PrescriptionPK prescriptionPK = new PrescriptionPK(prescriptionDTO.getIdPatient(), prescriptionDTO.getIdMedication());
        prescriptionEntity.setPrescriptionPK(prescriptionPK);
        prescriptionEntity.setPatientEntity(patientRepository.findById(prescriptionDTO.getIdPatient()));
        prescriptionEntity.setMedicationEntity(medicationRepository.findById(prescriptionDTO.getIdMedication()));
        DoctorEntity doctorEntity = doctorRepository.findById(prescriptionDTO.getIdDoctor());
        prescriptionEntity.setDoctorId(doctorEntity);
        System.out.println(prescriptionEntity);
        return prescriptionRepository.save(prescriptionEntity);

    }
}
