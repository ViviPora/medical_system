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

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setBirthDate(doctorDTO.getBirtDate());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setAddress(addressEntity);
        doctor.setGender(doctorDTO.getGender());
        doctor.setExperience(doctorDTO.getExperience());
        doctor.setDegreeNumber(doctorDTO.getDegreeNumber());

        DoctorEntity doctorEntity = doctorRepository.save(doctor);
        return doctorEntity;
    }

    public Iterable<DoctorEntity> findAll(){
        return this.doctorRepository.findAll();
    }
    public void delete(int id) {
        this.doctorRepository.deleteById(id);
    }

}
