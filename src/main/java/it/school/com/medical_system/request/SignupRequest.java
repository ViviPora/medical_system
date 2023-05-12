package it.school.com.medical_system.request;

import it.school.com.medical_system.entities.RoleEntity;
import it.school.com.medical_system.entities.UserEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SignupRequest {
    private int id;
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private int age;
    private boolean active;
    Set<String> role;

    public static SignupRequest from(UserEntity userEntity) {
        return SignupRequest.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .age(userEntity.getAge())
                //.role(userEntity.getRoles())
                .build();
    }

}
