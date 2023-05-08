package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AddressEntity;
import it.school.com.medical_system.validators.NoDigits;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AddressDTO {
    int id;
    @NoDigits
    @NotNull
    String country;
    @NoDigits
    @NotNull
    String city;
    @NoDigits
    @NotNull
    String street;
    String address;

    public static AddressDTO from(AddressEntity address) {
        return AddressDTO.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .address(address.getAddress())
                .build();
    }
}
