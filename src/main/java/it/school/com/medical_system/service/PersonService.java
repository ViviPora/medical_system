package it.school.com.medical_system.service;

import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.PersonEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public PersonEntity add(PersonEntity person) {
        AddressEntity address = new AddressEntity();
        address.setCity(person.getAddress().getCity());
        address.setCountry(person.getAddress().getCountry());
        address.setAddress(person.getAddress().getAddress());
        address.setStreet(person.getAddress().getStreet());

        AddressEntity addressEntity = addressRepository.save(address);

        PersonEntity personEntity = null;
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setEmail(person.getEmail());
        personEntity.setGender(person.getGender());
        personEntity.setPhone(person.getPhone());
        personEntity.setAddress(addressEntity);
        personEntity.setBirthDate(person.getBirthDate());

        personRepository.save(personEntity);

        return personEntity;
    }


}
