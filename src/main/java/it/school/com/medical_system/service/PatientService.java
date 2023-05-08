package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PatientDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AddressRepository addressRepository;

    public PatientEntity add(PatientDTO patientDTO) {
        log.info("Add new address");
        AddressEntity address = new AddressEntity();
        address.setCountry(patientDTO.getCountry());
        address.setCity(patientDTO.getCity());
        address.setStreet(patientDTO.getStreet());
        address.setAddress(patientDTO.getAddress());
        log.info("Saving address to database");
        AddressEntity addressEntity = addressRepository.save(address);
        log.info("Address successfully saved");
        log.info("Add new patient");
        PatientEntity patient = new PatientEntity();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setBirthDate(patientDTO.getBirtDate());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(addressEntity);
        patient.setEnrollmentDate(patientDTO.getEnrollmentDate());
        patient.setInsuranceNumber(patientDTO.getInsuranceNumber());
        patient.setInsuranceCompany(patientDTO.getInsuranceCompany());
        log.info("Saving patient to database");
        PatientEntity patientEntity = patientRepository.save(patient);
        log.info("Patient successfully saved");
        return patientEntity;
    }

    public Iterable<PatientEntity> findAll() {
        log.info("Find all patients");
        return this.patientRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException {
        log.info("Search for the patient you want to delete by id");
        this.patientRepository.findById(id).orElseThrow(() -> new InexistentResourceException("this patient does not exist in data base"));
        log.info("The patient to delete has been found and will be deleted ");
        this.patientRepository.deleteById(id);
        log.info("The patient has been successfully deleted");
    }
}
