package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PrescriptionDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.MedicationRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //TODO log for prescription

    public PrescriptionEntity add(PrescriptionDTO prescriptionDTO) throws InexistentResourceException {
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        Optional<DoctorEntity> doctor = this.doctorRepository.findByLastNameAndFirstName(prescriptionDTO.getDoctorLastname(), prescriptionDTO.getDoctorFirstname());
        Optional<PatientEntity> patient = this.patientRepository.findByLastNameAndFirstName(prescriptionDTO.getPatientLastname(), prescriptionDTO.getPatientFirstname());
        Optional<MedicationEntity> medication = this.medicationRepository.findByName(prescriptionDTO.getMedicationName());
        if (!doctor.isPresent()) {
            throw new InexistentResourceException("Doctor not found!");
        }
        if (!patient.isPresent()) {
            throw new InexistentResourceException("Patient not found!");
        }
        if (!medication.isPresent()) {
            throw new InexistentResourceException("Medication not found!");
        }
        PrescriptionPK prescriptionPK = new PrescriptionPK(doctor.get().getId(), medication.get().getId());
        prescriptionEntity.setPrescriptionPK(prescriptionPK);
        prescriptionEntity.setPatientEntity(patient.get());
        prescriptionEntity.setMedicationEntity(medication.get());
        prescriptionEntity.setDoctorId(doctor.get());
        return prescriptionRepository.save(prescriptionEntity);
    }

    public Iterable<PrescriptionEntity> findAll() {
        return this.prescriptionRepository.findAll();
    }

    public void delete(int id, int id2) throws InexistentResourceException {
        Optional<PrescriptionEntity> prescriptionEntity = Optional.ofNullable(this.prescriptionRepository.findByPatientEntityAndMedicationEntity(patientRepository.findById(id), medicationRepository.findById(id2)));
        if (!prescriptionEntity.isPresent()) {
            throw new InexistentResourceException("This prescription does not exist");
        }
        this.prescriptionRepository.deleteById(id);
    }
}
