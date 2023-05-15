package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.AppointmentDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.exception.AlreadyExistsException;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.exception.NotAvailableException;
import it.school.com.medical_system.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public AppointmentEntity add(AppointmentDTO appointmentDTO) throws AlreadyExistsException, NotAvailableException, InexistentResourceException {
        log.info("Add new appointment");
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        if (roomRepository.findByRoomNumber(appointmentDTO.getRoomNo()).isAvailable()) {
            log.info("Check if doctor or nurse is available for that moment");

            Optional<DoctorEntity> doctor =
                    doctorRepository.findByLastNameAndFirstName(appointmentDTO.getDoctorLastname(), appointmentDTO.getDoctorLastname());
            if (!doctor.isPresent()) {
                throw new InexistentResourceException("Doctor not found");
            }
            Optional<PatientEntity> patient =
                    patientRepository.findByLastNameAndFirstName(appointmentDTO.getPatientLastname(), appointmentDTO.getPatientFirstname());
            if (!patient.isPresent()) {
                throw new InexistentResourceException("Patient not found");
            }

            Optional<NurseEntity> nurse =
                    nurseRepository.findByLastNameAndFirstName(appointmentDTO.getNurseLastname(), appointmentDTO.getNurseFirstname());
            if (nurse.isPresent()) {
                throw new InexistentResourceException("Nurse not found!");
            }
            appointmentEntity.setDoctor(doctor.get());
            appointmentEntity.setPatient(patient.get());
            appointmentEntity.setNurse(nurse.get());
            if (!alreadyExistsAppointment(appointmentDTO)) {
                appointmentEntity.setRoom(roomRepository.findByRoomNumber(appointmentDTO.getRoomNo()));
                appointmentEntity.setStartAppointment(appointmentDTO.getAppointmentStart());
                appointmentEntity.setEndAppointment(appointmentDTO.getAppointmentEnd());
                log.info("Saving appointment to database");
                AppointmentEntity appointment = appointmentRepository.save(appointmentEntity);
                log.info("Appointment successfully saved");
                return appointment;
            } else throw new AlreadyExistsException("Can not make an appointment at that time!");
        } else throw new NotAvailableException("Room is not available!");
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

    public boolean alreadyExistsAppointment(AppointmentDTO appointmentDTO) {
        boolean existsDoc = true;
        boolean existsNurse = true;
        log.info("Check if doctor or nurse is available for that moment");
        Iterable<AppointmentEntity> appointmentEntities = this.appointmentRepository.findAll();
        for (AppointmentEntity appointment : appointmentEntities) {
            existsDoc = true;
            existsNurse = true;
            if (appointment.getDoctor().getLastName().equals(appointmentDTO.getDoctorLastname())) {
                if (appointment.getEndAppointment().isBefore(appointmentDTO.getAppointmentStart()) ||
                        appointment.getStartAppointment().isAfter(appointmentDTO.getAppointmentEnd())) {
                    existsDoc = false;
                    log.trace("Doctor available");
                }
            }
            if (appointment.getNurse().getLastName().equals(appointmentDTO.getNurseLastname())) {
                if (appointment.getEndAppointment().isBefore(appointmentDTO.getAppointmentStart()) ||
                        appointment.getStartAppointment().isAfter(appointmentDTO.getAppointmentEnd())) {
                    existsNurse = false;
                    log.trace("Nurse available");
                }
            }
        }
        return existsNurse || existsDoc;
    }
}
