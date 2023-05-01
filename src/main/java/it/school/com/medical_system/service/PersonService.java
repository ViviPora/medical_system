package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.PersonDTO;
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
    public PersonEntity add(PersonDTO person) {
        AddressEntity address = new AddressEntity();
        address.setCity(person.getCity());
        address.setCountry(person.getCountry());
        address.setAddress(person.getAddress());
        address.setStreet(person.getStreet());

        AddressEntity addressEntity = addressRepository.save(address);

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setEmail(person.getEmail());
        personEntity.setGender(person.getGender());
        personEntity.setPhone(person.getPhone());
        personEntity.setAddress(addressEntity);
        personEntity.setBirthDate(person.getBirtDate());
        personRepository.save(personEntity);
        return personEntity;
    }
       public Iterable<PersonEntity> findAll(){
                return this.personRepository.findAll();
            }


}
