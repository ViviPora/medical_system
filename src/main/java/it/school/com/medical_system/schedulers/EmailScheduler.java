package it.school.com.medical_system.schedulers;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.repositories.AppointmentRepository;
import it.school.com.medical_system.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@Component
@Slf4j
public class EmailScheduler {
    @Autowired
    EmailService emailService;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Scheduled(fixedRate = 100000000)
    public void remainderAppointment() throws MessagingException {
        log.trace("Fetching all appointments...");
        Iterable<AppointmentEntity>  appointmentEntities = this.appointmentRepository.findAll();
        log.trace("Appointments fetched successfully.");
        for (AppointmentEntity appointment : appointmentEntities){
            log.trace("Get appointments from database.");
            log.trace("Get appointments datetime.");
            if (appointment.getStartAppointment().isAfter(LocalDateTime.now().plusDays(1))&appointment.getStartAppointment().isBefore(LocalDateTime.now().plusDays(2))){
                log.trace("Sending email....");
                this.emailService.sendEmail(appointment.getPatient().getEmail(),"Appointment remainder", "Your appointment is in less then 24h!");
                log.trace("Email sent successfully");
            }
        }
    }

}
