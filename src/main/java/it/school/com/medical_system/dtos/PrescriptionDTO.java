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

    private int idPatient;
    private int idMedication;
    private int idDoctor;

    public static PrescriptionDTO from(PrescriptionEntity prescriptionEntity) {
        return PrescriptionDTO.builder()
                .idPatient(prescriptionEntity.getPatientEntity().getId())
                .idMedication(prescriptionEntity.getMedicationEntity().getId())
                .idDoctor(prescriptionEntity.getDoctorId().getId())
                .build();
    }
}
