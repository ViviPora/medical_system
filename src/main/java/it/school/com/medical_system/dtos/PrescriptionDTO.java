package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.PrescriptionEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionDTO {

//    private int idPatient;
//    private int idMedication;
//    private int idDoctor;
    private String patientLastname;
    private String patientFirstname;
    private String medicationName;
    private String doctorLastname;
    private String doctorFirstname;

    public static PrescriptionDTO from(PrescriptionEntity prescriptionEntity) {
        return PrescriptionDTO.builder()
                .patientLastname(prescriptionEntity.getPatientEntity().getLastName())
                .patientFirstname(prescriptionEntity.getPatientEntity().getFirstName())
                .medicationName(prescriptionEntity.getMedicationEntity().getName())
                .doctorLastname(prescriptionEntity.getDoctorId().getLastName())
                .doctorFirstname(prescriptionEntity.getDoctorId().getLastName())
                .build();
    }
}
