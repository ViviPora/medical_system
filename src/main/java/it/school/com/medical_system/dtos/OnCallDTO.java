package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.OnCallEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class OnCallDTO {
    private int id;
    @NotEmpty
    private String doctorFirstName;
    @NotEmpty
    private String doctorLastName;
    @NotEmpty
    private String nurseFirstName;
    @NotEmpty
    private String nurseLastName;
    @Future
    private LocalDateTime starOnCall;
    @Future
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
