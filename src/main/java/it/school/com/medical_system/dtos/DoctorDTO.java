package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.model.Gender;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DoctorDTO {
    private Integer id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private LocalDate birtDate;
    @NotEmpty
    @Email
    String email;
    @NotEmpty
    String phone;
    @NotEmpty
    Gender gender;
    @NotEmpty
    String country;
    @NotEmpty
    String city;
    @NotEmpty
    String street;
    @NotEmpty
    String address;
    @NotEmpty
    String degreeNumber;
    @NotEmpty
    Integer experience;

    public static DoctorDTO from(DoctorEntity doctorEntity) {
        return DoctorDTO.builder()
                .id(doctorEntity.getId())
                .firstName(doctorEntity.getFirstName())
                .lastName(doctorEntity.getLastName())
                .birtDate(doctorEntity.getBirthDate())
                .email(doctorEntity.getEmail())
                .phone(doctorEntity.getPhone())
                .gender(doctorEntity.getGender())
                .country(doctorEntity.getAddress().getCountry())
                .city(doctorEntity.getAddress().getCity())
                .street(doctorEntity.getAddress().getStreet())
                .address(doctorEntity.getAddress().getAddress())
                .degreeNumber(doctorEntity.getDegreeNumber())
                .experience(doctorEntity.getExperience())
                .build();
    }

    public static List<DoctorDTO> from(List<DoctorEntity> doctorEntities) {
        List<DoctorDTO> results = new ArrayList<>();
        for (DoctorEntity doctorEntity : doctorEntities) {
            results.add(DoctorDTO.from(doctorEntity));
        }
        return results;
    }

}
