package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.AppointmentDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.exception.AlreadyExistsException;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@Slf4j
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RoomRepository roomRepository;


    public AppointmentEntity add(AppointmentDTO appointmentDTO) throws AlreadyExistsException {

        log.info("Add new appointment");
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setDoctor(doctorRepository.findByLastName(appointmentDTO.getDoctorName()));
        appointmentEntity.setPatient(patientRepository.findByLastName(appointmentDTO.getPatientName()));
        appointmentEntity.setNurse(nurseRepository.findByLastName(appointmentDTO.getNurseName()));
        appointmentEntity.setRoom(roomRepository.findByRoomNumber(appointmentDTO.getRoomNo()));
        appointmentEntity.setStartAppointment(appointmentDTO.getAppointmentStart());
        appointmentEntity.setEndAppointment(appointmentDTO.getAppointmentEnd());
        log.info("Saving appointment to database");
        AppointmentEntity appointment = appointmentRepository.save(appointmentEntity);
        log.info("Appointment successfully saved");

        return appointment;

    }


    public Iterable<AppointmentEntity> findAll() {
        log.info("Find all appointments");
        return this.appointmentRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException {
        log.info("Search for the appointment you want to delete by id");
        this.appointmentRepository.findById(id).orElseThrow(() -> new InexistentResourceException("This appointment does not exist! "));
        log.info("The appointment to delete has been found and will be deleted ");
        this.appointmentRepository.deleteById(id);
        log.info("The appointment has been successfully deleted");
    }


}
