package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.DoctorDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DoctorService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public DoctorEntity add(DoctorDTO doctorDTO) {
        log.info("Add new doctor address");
        AddressEntity address = new AddressEntity();
        address.setCountry(doctorDTO.getCountry());
        address.setCity(doctorDTO.getCity());
        address.setStreet(doctorDTO.getStreet());
        address.setAddress(doctorDTO.getAddress());
        log.info("Saving address from doctor to the database...");
        AddressEntity addressEntity = addressRepository.save(address);
        log.info("Address successfully saved from doctor to the database");
        log.info("Add new doctor");
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
        log.info("Saving doctor to the database...");
        DoctorEntity doctorEntity = doctorRepository.save(doctor);
        log.info("Doctor successfully saved");
        return doctorEntity;
    }

    public Iterable<DoctorEntity> findAll(){
        log.info("Find all doctors");
        return this.doctorRepository.findAll();
    }
    public void delete(int id) throws InexistentResourceException{
        log.info("Search for the doctor you want to delete by id");
        this.doctorRepository.findById(id).orElseThrow(()-> new InexistentResourceException("this doctor does not exist!"));
        log.info("The doctor to delete has been found and will be deleted ");
        this.doctorRepository.deleteById(id);
        log.info("The doctor has been successfully deleted");
    }

}
