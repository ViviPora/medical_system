package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.NurseDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NurseService {
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
        NurseEntity nurse = new NurseEntity();
        nurse.setFirstName(nurseDTO.getFirstName());
        nurse.setLastName(nurseDTO.getLastName());
        nurse.setBirthDate(nurseDTO.getBirtDate());
        nurse.setEmail(nurseDTO.getEmail());
        nurse.setPhone(nurseDTO.getPhone());
        nurse.setAddress(addressEntity);
        nurse.setGender(nurseDTO.getGender());
        nurse.setExperience(nurseDTO.getExperience());
        nurse.setDegreeNumber(nurseDTO.getDegreeNumber());
        NurseEntity nurseEntity = nurseRepository.save(nurse);
        return nurseEntity;
    }
       public Iterable<NurseEntity> findAll(){
                return this.nurseRepository.findAll();
            }
}
