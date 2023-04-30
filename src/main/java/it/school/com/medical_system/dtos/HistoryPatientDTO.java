package it.school.com.medical_system.dtos;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//ToDo verifica
public class HistoryPatientDTO {
    String lastName;
    String firstName;
    String medicalHistory;
}

