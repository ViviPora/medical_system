package it.school.com.medical_system.schedulers;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.repositories.AppointmentRepository;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.PatientRepository;
import it.school.com.medical_system.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Component
@Slf4j
public class DailyReportScheduler {
    @Autowired
    private EmailService emailService;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Scheduled(fixedRate = 1000)
    public void sendReportToDoctor() {
        Iterable<DoctorEntity> doctorEntityList = this.doctorRepository.findAll();
        log.info("send report");
        for (DoctorEntity doctor : doctorEntityList) {
            List<AppointmentEntity> appointmentEntityList = this.appointmentRepository.appointmentList(doctor.getId());

            try (StringWriter stringWriter = new StringWriter()) {
                CSVWriter csvWriter = new CSVWriter(stringWriter);

                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(csvWriter).build();
                beanToCsv.write(appointmentEntityList);
                String csvReport = stringWriter.toString();
                csvWriter.close();
                this.emailService.sendEmail(doctor.getEmail(), "Daily report", "Hello! This is your appointment report for today.", csvReport);
            } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                log.error("Something exception happened when creating report for doctor with name {} due to {}", doctor.getLastName(), e.getMessage());
            } catch (MessagingException e) {
                log.error("Something exception happened when sending email to {} due to {}", doctor.getEmail(), e.getMessage());
            }
        }
    }
}
