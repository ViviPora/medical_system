package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Integer> {
    AppointmentEntity deleteByStartAppointmentAndEndAppointmentAndDoctor(LocalDate appointmentStart, LocalDate appointmentEnd, DoctorEntity doctor);
    @Query("SELECT a FROM AppointmentEntity a WHERE a.doctor.id=:idDoctor")
    List<AppointmentEntity> appointmentList(@Param("idDoctor") int idDoctor);

}
