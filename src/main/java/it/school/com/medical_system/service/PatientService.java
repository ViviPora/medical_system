package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PatientDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.entities.PersonEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public PatientEntity add(PatientDTO patientDTO) {
        AddressEntity address = new AddressEntity();
        address.setCountry(patientDTO.getCountry());
        address.setCity(patientDTO.getCity());
        address.setStreet(patientDTO.getStreet());
        address.setAddress(patientDTO.getAddress());
        AddressEntity addressEntity = addressRepository.save(address);

        PersonEntity person = null;

//        person = new PersonEntity();
        person.setFirstName(patientDTO.getFirstName());
        person.setLastName(patientDTO.getLastName());
        person.setEmail(patientDTO.getEmail());
        person.setGender(patientDTO.getGender());
        person.setBirthDate(patientDTO.getBirtDate());
        person.setPhone(patientDTO.getPhone());
        person.setAddress(addressEntity);
        PersonEntity personEntity = personRepository.save(person);

        PatientEntity patient = new PatientEntity();
        patient.setEnrollmentDate(patientDTO.getEnrollmentDate());
        patient.setInsuranceNumber(patientDTO.getInsuranceNumber());
        patient.setInsuranceCompany(patientDTO.getInsuranceCompany());
        PatientEntity patientEntity = patientRepository.save(patient);

        return patientEntity;
    }
}
