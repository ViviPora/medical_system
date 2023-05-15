package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.validators.NoDigits;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.After;

import javax.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class AppointmentDTO {
    private Integer id;
    @NoDigits
    @NotNull
    private String doctorLastname;
    @NoDigits
    @NotNull
    private String doctorFirstname;
    @NoDigits
    @NotNull
    private String patientLastname;
    @NoDigits
    @NotNull
    private String patientFirstname;
    @NoDigits
    @NotNull
    private String nurseLastname;
    @NoDigits
    @NotNull
    private String nurseFirstname;
    @Digits(integer = 4, fraction = 0, message = "Room number need to be digits")
    @Positive
    private Integer roomNo;
    @FutureOrPresent
    private LocalDateTime appointmentStart;
    @Future
    private LocalDateTime appointmentEnd;
    public static AppointmentDTO from(AppointmentEntity appointmentEntity){
        return AppointmentDTO.builder()
                .id(appointmentEntity.getId())
                .doctorLastname(appointmentEntity.getDoctor().getLastName())
                .doctorFirstname(appointmentEntity.getDoctor().getFirstName())
                .patientLastname(appointmentEntity.getPatient().getLastName())
                .patientFirstname(appointmentEntity.getPatient().getFirstName())
                .nurseLastname(appointmentEntity.getNurse().getLastName())
                .nurseFirstname(appointmentEntity.getNurse().getFirstName())
                .roomNo(appointmentEntity.getRoom().getRoomNumber())
                .appointmentStart(appointmentEntity.getStartAppointment())
                .appointmentEnd(appointmentEntity.getEndAppointment())
                .build();
    }

}
