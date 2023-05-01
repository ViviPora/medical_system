package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.OnCallEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class OnCallDTO {
    private int id;
    private String doctorFirstName;
    private String doctorLastName;
    private String nurseFirstName;
    private String nurseLastName;
    private LocalDateTime starOnCall;
    private LocalDateTime endOnCall;

    public static OnCallDTO from(OnCallEntity onCallEntity){
        return OnCallDTO.builder()
                .id(onCallEntity.getId())
                .doctorFirstName(onCallEntity.getDoctor().getFirstName())
                .doctorLastName(onCallEntity.getDoctor().getLastName())
                .nurseFirstName(onCallEntity.getNurse().getFirstName())
                .nurseLastName(onCallEntity.getNurse().getLastName())
                .starOnCall(onCallEntity.getStarOnCall())
                .endOnCall(onCallEntity.getEndOnCall())
                .build();
    }
}
