package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.NurseDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.PersonEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.NurseRepository;
import it.school.com.medical_system.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NurseService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private NurseRepository nurseRepository;

    @Transactional
    public NurseEntity add(NurseDTO nurseDTO) {
        AddressEntity address = new AddressEntity();
        address.setCountry(nurseDTO.getCountry());
        address.setCity(nurseDTO.getCity());
        address.setStreet(nurseDTO.getStreet());
        address.setAddress(nurseDTO.getAddress());
        AddressEntity addressEntity = addressRepository.save(address);
//
        PersonEntity person = new PersonEntity();
        person.setFirstName(nurseDTO.getFirstName());
        person.setLastName(nurseDTO.getLastName());
        person.setBirthDate(nurseDTO.getBirtDate());
        person.setEmail(nurseDTO.getEmail());
        person.setPhone(nurseDTO.getPhone());
        person.setAddress(addressEntity);
        person.setGender(nurseDTO.getGender());

    //    PersonEntity personEntity = personRepository.save(person);
        NurseEntity nurse = new NurseEntity();
        nurse.setExperience(nurseDTO.getExperience());
        nurse.setDegreeNumber(nurseDTO.getDegreeNumber());
      //  nurse.setPersonEntity(personEntity);
        NurseEntity nurseEntity = nurseRepository.save(nurse);
        return nurseEntity;

    }
}
