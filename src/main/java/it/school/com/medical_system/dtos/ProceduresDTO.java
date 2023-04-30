package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.ProceduresEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProceduresDTO {
    private int id;
    private String name;
    private int cost;

    public static ProceduresDTO from(ProceduresEntity proceduresEntity) {
        return ProceduresDTO.builder()
                .id(proceduresEntity.getId())
                .name(proceduresEntity.getName())
                .cost(proceduresEntity.getCost())
                .build();
    }

}
