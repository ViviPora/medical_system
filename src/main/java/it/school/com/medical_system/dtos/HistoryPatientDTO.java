package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.HistoryPatientEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class HistoryPatientDTO {
    @NotEmpty
    String lastName;
    @NotEmpty
    String firstName;
    String medicalHistory;

}

