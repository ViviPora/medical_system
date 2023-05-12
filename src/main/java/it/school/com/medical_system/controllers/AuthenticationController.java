package it.school.com.medical_system.controllers;

import it.school.com.medical_system.entities.RoleEntity;
import it.school.com.medical_system.entities.UserEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.model.Role;
import it.school.com.medical_system.repositories.RoleRepository;
import it.school.com.medical_system.repositories.UserRepository;
import it.school.com.medical_system.request.LoginRequest;
import it.school.com.medical_system.request.SignupRequest;
import it.school.com.medical_system.responses.JwtResponse;
import it.school.com.medical_system.security.jwt.JwtUtils;
import it.school.com.medical_system.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SignupService signupService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateToken(authentication);

        User user = (User) authentication.getPrincipal();

        JwtResponse jwtResponse = new JwtResponse(user.getUsername(), jwt);

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRequest> registerUser(@RequestBody SignupRequest signupRequest) throws InexistentResourceException {

        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setAge(signupRequest.getAge());

        Set<String> signupRequestRole = signupRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();
        if (signupRequestRole == null) {
            RoleEntity userRole = roleRepository.findByName(Role.ROLE_DOCTOR).orElseThrow(() -> new InexistentResourceException("Add role!!!"));
            roles.add(userRole);
        } else {
            signupRequestRole.forEach(role -> {
                        switch (role) {
                            case "administrator":
                                RoleEntity adminRole = roleRepository.findByName(Role.ROLE_ADMIN).orElseThrow(() -> new RuntimeException());
                                roles.add(adminRole);
                                break;
                            case "doctor":
                                RoleEntity doctorRole = roleRepository.findByName(Role.ROLE_DOCTOR).orElseThrow(() -> new RuntimeException());
                                roles.add(doctorRole);
                                break;
                            case "asistenta":
                                RoleEntity nurseRole = roleRepository.findByName(Role.ROLE_NURSE).orElseThrow(() -> new RuntimeException());
                                roles.add(nurseRole);
                                break;
                            case "pacient":
                                RoleEntity patientRole = roleRepository.findByName(Role.ROLE_PATIENT).orElseThrow(() -> new RuntimeException());
                                roles.add(patientRole);
                                break;
                            default:
                                new InexistentResourceException("Incorrect role");
                        }
                    }
            );
        }
        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}