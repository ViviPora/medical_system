package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Integer> {
    AppointmentEntity deleteByStartAppointmentAndEndAppointmentAndDoctor(LocalDate appointmentStart, LocalDate appointmentEnd, DoctorEntity doctor);

}
