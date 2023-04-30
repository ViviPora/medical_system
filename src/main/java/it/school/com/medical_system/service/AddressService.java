package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.AddressDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public AddressEntity add(AddressDTO addressDTO){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setAddress(addressDTO.getAddress());

        return addressRepository.save(addressEntity);

    }
}
