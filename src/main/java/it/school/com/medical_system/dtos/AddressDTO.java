package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AddressEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AddressDTO {
    int id;
    String country;
    String city;
    String street;
    String address;

    public static AddressDTO from(AddressEntity address){
        return AddressDTO.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .address(address.getAddress())
                .build();
    }
}
