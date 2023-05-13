package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.validators.NoDigits;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private String doctorName;
    @NoDigits
    @NotNull
    private String patientName;
    @NoDigits
    @NotNull
    private String nurseName;
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
                .doctorName(appointmentEntity.getDoctor().getLastName())
                .patientName(appointmentEntity.getPatient().getLastName())
                .nurseName(appointmentEntity.getNurse().getLastName())
                .roomNo(appointmentEntity.getRoom().getRoomNumber())
                .appointmentStart(appointmentEntity.getStartAppointment())
                .appointmentEnd(appointmentEntity.getEndAppointment())
                .build();
    }

}
