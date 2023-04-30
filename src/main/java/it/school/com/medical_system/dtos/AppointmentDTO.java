package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AppointmentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class AppointmentDTO {
    private Integer id;
    private String doctorName;
    private String patientName;
    private String nurseName;
    private Integer roomNo;
    private LocalDate appointmentStart;
    private LocalDate appointmentEnd;
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
