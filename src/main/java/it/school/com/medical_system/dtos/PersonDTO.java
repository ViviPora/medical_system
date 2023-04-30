package it.school.com.medical_system.dtos;

import it.school.com.medical_system.model.Gender;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PersonDTO {
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
}
