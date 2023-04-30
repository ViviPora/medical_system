package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.DoctorDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PersonEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public DoctorEntity add(DoctorDTO doctorDTO) {
        AddressEntity address = new AddressEntity();
        address.setCountry(doctorDTO.getCountry());
        address.setCity(doctorDTO.getCity());
        address.setStreet(doctorDTO.getStreet());
        address.setAddress(doctorDTO.getAddress());
        AddressEntity addressEntity = addressRepository.save(address);

        PersonEntity person = new PersonEntity();
        person.setFirstName(doctorDTO.getFirstName());
        person.setLastName(doctorDTO.getLastName());
        person.setBirthDate(doctorDTO.getBirtDate());
        person.setEmail(doctorDTO.getEmail());
        person.setPhone(doctorDTO.getPhone());
        person.setAddress(addressEntity);
        person.setGender(doctorDTO.getGender());

     //   PersonEntity personEntity = personRepository.save(person);
        DoctorEntity doctor = new DoctorEntity();
        doctor.setExperience(doctorDTO.getExperience());
        doctor.setDegreeNumber(doctorDTO.getDegreeNumber());
      //  doctor.setPersonEntity(personEntity);
        DoctorEntity doctorEntity = doctorRepository.save(doctor);
        return doctorEntity;
    }

}
