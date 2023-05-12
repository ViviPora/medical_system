package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.MedicationEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class MedicationDTO {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String brand;
    private String description;

    public static MedicationDTO from(MedicationEntity medicationEntity){
        return MedicationDTO.builder()
                .id(medicationEntity.getId())
                .name(medicationEntity.getName())
                .brand(medicationEntity.getBrand())
                .description(medicationEntity.getDescription())
                .build();
    }
}
