package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.AppointmentDTO;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
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
//todo findbyLastNameAndFirstName -> unique?
    public AppointmentEntity add(AppointmentDTO appointmentDTO) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setDoctor(doctorRepository.findByLastName(appointmentDTO.getDoctorName()));
        appointmentEntity.setPatient(patientRepository.findByLastName(appointmentDTO.getPatientName()));
        appointmentEntity.setNurse(nurseRepository.findByLastName(appointmentDTO.getNurseName()));
        appointmentEntity.setRoom(roomRepository.findByRoomNumber(appointmentDTO.getRoomNo()));
        appointmentEntity.setStartAppointment(appointmentDTO.getAppointmentStart());
        appointmentEntity.setEndAppointment(appointmentDTO.getAppointmentEnd());
        return appointmentRepository.save(appointmentEntity);
    }

}
