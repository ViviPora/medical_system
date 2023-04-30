package it.school.com.medical_system.service;
import it.school.com.medical_system.dtos.PatientDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AddressRepository addressRepository;

    public PatientEntity add(PatientDTO patientDTO) {
        AddressEntity address = new AddressEntity();
        address.setCountry(patientDTO.getCountry());
        address.setCity(patientDTO.getCity());
        address.setStreet(patientDTO.getStreet());
        address.setAddress(patientDTO.getAddress());
        AddressEntity addressEntity = addressRepository.save(address);
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
        PatientEntity patientEntity = patientRepository.save(patient);
        return patientEntity;
    }
}
