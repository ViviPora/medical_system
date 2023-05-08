package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PrescriptionDTO;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PrescriptionEntity;
import it.school.com.medical_system.entities.PrescriptionPK;
import it.school.com.medical_system.exception.InexistentResourceException;
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
    //TODO log for prescription
    //TODO if you don t have time delete this-> DELETE prescription
    public PrescriptionEntity add(PrescriptionDTO prescriptionDTO) {
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        PrescriptionPK prescriptionPK = new PrescriptionPK(prescriptionDTO.getIdPatient(), prescriptionDTO.getIdMedication());
        prescriptionEntity.setPrescriptionPK(prescriptionPK);
        //todo exception -> no content
        prescriptionEntity.setPatientEntity(patientRepository.findById(prescriptionDTO.getIdPatient()).get());
        prescriptionEntity.setMedicationEntity(medicationRepository.findById(prescriptionDTO.getIdMedication()).get());
        DoctorEntity doctorEntity = doctorRepository.findById(prescriptionDTO.getIdDoctor()).get();
        prescriptionEntity.setDoctorId(doctorEntity);
        System.out.println(prescriptionEntity);
        return prescriptionRepository.save(prescriptionEntity);
    }

    public Iterable<PrescriptionEntity> findAll() {
        return this.prescriptionRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException {
        this.prescriptionRepository.findById(id).orElseThrow(() -> new InexistentResourceException("This prescription does not exist"));
        this.prescriptionRepository.deleteById(id);

    }
}
