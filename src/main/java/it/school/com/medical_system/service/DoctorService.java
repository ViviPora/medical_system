package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.DoctorDTO;
import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.exception.AlreadyExistsException;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.exception.NotEditableException;
import it.school.com.medical_system.repositories.AddressRepository;
import it.school.com.medical_system.repositories.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DoctorService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public DoctorEntity add(DoctorDTO doctorDTO) throws AlreadyExistsException {
        if (!doctorRepository.existsByLastNameAndFirstName(doctorDTO.getLastName(),doctorDTO.getFirstName())) {
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
            doctor.setId(doctorDTO.getId());
            doctor.setFirstName(doctorDTO.getFirstName());
            doctor.setLastName(doctorDTO.getLastName());
            doctor.setBirthDate(doctorDTO.getBirtDate());
            doctor.setEmail(doctorDTO.getEmail());
            doctor.setPhone(doctorDTO.getPhone());
            doctor.setAddress(addressEntity);
            doctor.setGender(doctorDTO.getGender());
            doctor.setExperience(doctorDTO.getExperience());
            doctor.setDegreeNumber(doctorDTO.getDegreeNumber());
            doctor.setSpecialization(doctorDTO.getSpecialization());
            log.info("Saving doctor to the database...");
            DoctorEntity doctorEntity = doctorRepository.save(doctor);
            log.info("Doctor successfully saved");
            return doctorEntity;
        }
        else {
            throw new AlreadyExistsException("Doctor already in the database");
        }
    }

    public Iterable<DoctorEntity> findAll() {
        log.info("Find all doctors");
        return this.doctorRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException {
        log.info("Search for the doctor you want to delete by id");
        this.doctorRepository.findById(id).orElseThrow(() -> new InexistentResourceException("this doctor does not exist!"));
        log.info("The doctor to delete has been found and will be deleted ");
        this.doctorRepository.deleteById(id);
        log.info("The doctor has been successfully deleted");
    }

    public List<DoctorEntity> searchByExperienceAndSpecialization(int experience, String specialization) {

        Iterable<DoctorEntity> dbDoctors = this.doctorRepository.findAll();
        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (DoctorEntity doctorEntity : dbDoctors) {
            doctorEntities.add(doctorEntity);
        }
        if (experience != 0) {
            List<DoctorEntity> doctorByExperience = this.doctorRepository.findByExperienceGreaterThan(experience);
            doctorEntities.retainAll(doctorByExperience);
        }
        if (specialization != null && !specialization.isEmpty()) {
            List<DoctorEntity> doctorBySpecialization = this.doctorRepository.findBySpecialization(specialization);
            doctorEntities.retainAll(doctorBySpecialization);
        }
        return doctorEntities;
    }

    public DoctorEntity updatePartial(int id, DoctorDTO doctorDTO) throws InexistentResourceException, NotEditableException {
        Optional<DoctorEntity> optionalDoctor = this.doctorRepository.findById(id);
        Optional<AddressEntity> optionalAddress = this.doctorRepository.findAddress(id);
        if (!optionalDoctor.isPresent()) {
            throw new InexistentResourceException("Doctor does not exists");
        }
        DoctorEntity doctor = optionalDoctor.get();
        AddressEntity address = optionalAddress.get();
        if (doctorDTO.getFirstName() != null || doctorDTO.getLastName() != null || doctorDTO.getBirtDate() != null || doctorDTO.getGender() != null || doctorDTO.getDegreeNumber() != null || doctorDTO.getExperience() != null) {
            throw new NotEditableException("You can modify just phone, email, address");
        }
        if (doctorDTO.getPhone() != null) {
            doctor.setPhone(doctorDTO.getPhone());
        }
        if (doctorDTO.getEmail() != null) {
            doctor.setEmail(doctorDTO.getEmail());
        }
        if (doctorDTO.getCountry() != null) {
            address.setCountry(doctorDTO.getCountry());
        }
        if (doctorDTO.getCity() != null) {
            address.setCity(doctorDTO.getCity());
        }
        if (doctorDTO.getStreet() != null) {
            address.setStreet(doctorDTO.getStreet());
        }
        if (doctorDTO.getAddress() != null) {
            address.setAddress(doctorDTO.getAddress());
        }
        doctor.setAddress(address);
        this.doctorRepository.save(doctor);
        return doctor;
    }

}
