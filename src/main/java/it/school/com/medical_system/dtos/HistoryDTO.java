package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.HistoryEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryDTO {
    private Integer id;
    private String history;

    public static HistoryDTO from(HistoryEntity historyEntity){
        return HistoryDTO.builder()
                .id(historyEntity.getId())
                .history(historyEntity.getMedicalHistory())
                .build();

    }

}
