package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.RoomEntity;
import it.school.com.medical_system.model.RoomType;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDTO {
    private Integer id;
    private Integer number;
    private RoomType roomType;

    public static RoomDTO from(RoomEntity roomEntity){
        return RoomDTO.builder()
                .id(roomEntity.getId())
                .number(roomEntity.getRoomNumber())
                .roomType(roomEntity.getRoomType())
                .build();
    }
}
