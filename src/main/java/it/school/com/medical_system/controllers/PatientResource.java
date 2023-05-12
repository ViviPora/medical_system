package it.school.com.medical_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.school.com.medical_system.dtos.DoctorDTO;
import it.school.com.medical_system.dtos.DoctorListDTO;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
@Slf4j
@Validated
public class PatientResource {

    @Autowired
    private AdminService adminService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ProceduresService proceduresService;
    @Autowired
    private MedicationService medicationService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private HistoryPatientService historyPatientService;
    @Autowired
    private OnCallService onCallService;
    @Autowired
    private PatientProceduresService patientProceduresService;

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
}
