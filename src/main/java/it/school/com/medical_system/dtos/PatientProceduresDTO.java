package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.PatientProceduresEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PatientProceduresDTO {

    private String patientFirstName;
    private String patientLastName;
    private String procedureName;
    private String doctorFirstName;
    private String doctorLastName;
    private String description;

    public static PatientProceduresDTO from(PatientProceduresEntity patientProceduresEntity){
        return PatientProceduresDTO.builder()
                .patientFirstName(patientProceduresEntity.getPatient().getFirstName())
                .patientLastName(patientProceduresEntity.getPatient().getLastName())
                .procedureName(patientProceduresEntity.getProcedures().getName())
                .doctorFirstName(patientProceduresEntity.getDoctor().getFirstName())
                .doctorLastName(patientProceduresEntity.getDoctor().getLastName())
                .description(patientProceduresEntity.getDescription())
                .build();
    }
}
