package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.AddressDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public AddressEntity add(AddressDTO addressDTO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setAddress(addressDTO.getAddress());

        return addressRepository.save(addressEntity);

    }

    public Iterable<AddressEntity> findAll() {
        return this.addressRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException{
        this.addressRepository.findById(id).orElseThrow(()-> new InexistentResourceException("this address does not exist!"));
        this.addressRepository.deleteById(id);
    }

}
