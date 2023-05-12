package it.school.com.medical_system.service;

import it.school.com.medical_system.entities.RoomEntity;
import it.school.com.medical_system.entities.UserEntity;
import it.school.com.medical_system.repositories.UserRepository;
import it.school.com.medical_system.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;


    public UserEntity add(SignupRequest signupRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(signupRequest.getFirstName());
        userEntity.setLastName(signupRequest.getLastName());
        userEntity.setAge(signupRequest.getAge());
        userEntity.setUsername(signupRequest.getUsername());
        UserEntity user = userRepository.save(userEntity);
        return user;
    }
}
