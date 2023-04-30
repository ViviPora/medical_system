package it.school.com.medical_system.dtos;

import it.school.com.medical_system.entities.AddressEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDTO {
    int id;
    String country;
    String city;
    String street;
    String address;

    public AddressDTO from(AddressEntity address){
        return AddressDTO.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .address(address.getAddress())
                .build();
    }
}
