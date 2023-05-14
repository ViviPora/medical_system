package it.school.com.medical_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.school.com.medical_system.dtos.AppointmentDTO;
import it.school.com.medical_system.dtos.DoctorDTO;
import it.school.com.medical_system.dtos.DoctorListDTO;
import it.school.com.medical_system.dtos.PatientDTO;
import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.PatientEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.exception.NotEditableException;
import it.school.com.medical_system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
@Slf4j
@Validated
public class PatientResource {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private EmailService emailService;

    @Operation(summary = "Create patient")
    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = PatientDTO.class)))
    @PostMapping("/patient")
    @PreAuthorize("hasRole('PATIENT') or hasRole('NURSE') or hasRole('DOCTOR')")
    public ResponseEntity<PatientDTO> create(@Valid @RequestBody PatientDTO patientDTO) {
        log.debug("Create patient");
        PatientEntity patientEntity = this.patientService.add(patientDTO);
        return new ResponseEntity<>(PatientDTO.from(patientEntity), HttpStatus.CREATED);
    }

    @Operation(summary = "Search doctor by experience and specialization")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DoctorListDTO.class)))
    @GetMapping("/searchDocByExpAndSpec")
    public ResponseEntity<DoctorListDTO> searchDoctor(@RequestParam(value = "experience", required = false) int experience,
                                                      @RequestParam(value = "specialization", required = false) String specialization) {
        List<DoctorEntity> entityList = this.doctorService.searchByExperienceAndSpecialization(experience, specialization);
        List<DoctorDTO> doctorDTOList = DoctorDTO.from(entityList);
        return new ResponseEntity<>(new DoctorListDTO(doctorDTOList), HttpStatus.OK);
    }

    @Operation(summary = "Get all doctors")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DoctorListDTO.class)))
    @GetMapping("/doctors")
    public ResponseEntity<DoctorListDTO> getAllDoctor() {
        Iterable<DoctorEntity> doctors = this.doctorService.findAll();
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (DoctorEntity doctorEntity : doctors) {
            doctorDTOList.add(DoctorDTO.from(doctorEntity));
        }
        DoctorListDTO doctorListDTO = new DoctorListDTO(doctorDTOList);
        return new ResponseEntity<>(doctorListDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('PATIENT') or hasRole('NURSE') or hasRole('DOCTOR')")
    @Operation(summary = "Create appointment")
    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = AppointmentDTO.class)))
    @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR", content = @Content(schema = @Schema(implementation = AppointmentDTO.class)))
    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDTO> create(@Valid @RequestBody AppointmentDTO appointmentDTO) throws MessagingException {
        log.debug("Create appointment");
        AppointmentEntity appointmentEntity = this.appointmentService.add(appointmentDTO);
        log.trace("Sending email");
        this.emailService.sendEmail(appointmentEntity.getPatient().getEmail(), "Your appointment has been registered!",
                "This email is the confirmation of your appointment in the clinic");
        log.trace("Email sent successfully");
        return new ResponseEntity<>(appointmentDTO.from(appointmentEntity), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATIENT') or hasRole('NURSE') or hasRole('DOCTOR')")
    @Operation(summary = "Edit patient")
    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = PatientDTO.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = Void.class)))
    @PatchMapping("/updatePatient/{id}")
    public ResponseEntity<PatientDTO> updatePatientPartial(@PathVariable("id") int id, @RequestBody PatientDTO patientDTO) throws NotEditableException, InexistentResourceException {
        PatientEntity patientEntity = this.patientService.updatePartial(id, patientDTO);
        PatientDTO responseDTO = PatientDTO.from(patientEntity);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}