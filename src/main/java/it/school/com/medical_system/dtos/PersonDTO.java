package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.PersonEntity;
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
        public static PersonDTO from(PersonEntity person){

            return PersonDTO.builder()
                    .id(person.getId())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .birtDate(person.getBirthDate())
                    .email(person.getEmail())
                    .phone(person.getPhone())
                    .gender(person.getGender())
                    .country(person.getAddress().getCountry())
                    .city(person.getAddress().getCity())
                    .street(person.getAddress().getStreet())
                    .address(person.getAddress().getAddress())
                    .build();
}
}
