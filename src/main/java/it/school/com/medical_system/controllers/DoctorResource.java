package it.school.com.medical_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.school.com.medical_system.dtos.MedicationDTO;
import it.school.com.medical_system.dtos.MedicationListDTO;
import it.school.com.medical_system.dtos.PatientProceduresDTO;
import it.school.com.medical_system.dtos.PrescriptionDTO;
import it.school.com.medical_system.entities.MedicationEntity;
import it.school.com.medical_system.entities.PatientProceduresEntity;
import it.school.com.medical_system.entities.PrescriptionEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
@Slf4j
@Validated
public class DoctorResource {
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

    @Operation(summary = "Create prescription")
    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = PrescriptionDTO.class)))
    @PostMapping("/prescription")
    public ResponseEntity<PrescriptionDTO> create(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        log.debug("Create prescription");
        PrescriptionEntity prescriptionEntity = this.prescriptionService.add(prescriptionDTO);
        return new ResponseEntity<>(prescriptionDTO.from(prescriptionEntity), HttpStatus.CREATED);
    }

    @Operation(summary = "Create patient procedures")
    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = PatientProceduresDTO.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = Void.class)))
    @PostMapping("/patientprocedures")
    public ResponseEntity<PatientProceduresDTO> create(@Valid @RequestBody PatientProceduresDTO patientProceduresDTO) {
        log.debug("Create patient procedures");
        try {
            PatientProceduresEntity patientProceduresEntity = this.patientProceduresService.add(patientProceduresDTO);
            return new ResponseEntity<>(patientProceduresDTO.from(patientProceduresEntity), HttpStatus.CREATED);
        } catch (InexistentResourceException e) {
            log.warn("Inexistent resource exception: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Operation(summary = "Get medication")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = MedicationListDTO.class)))
    @GetMapping("/medication")
    public ResponseEntity<MedicationListDTO> getAllMedication() {
        Iterable<MedicationEntity> medication = this.medicationService.findAll();
        List<MedicationDTO> medicationDTOList = new ArrayList<>();
        for (MedicationEntity medicationEntity : medication) {
            medicationDTOList.add(MedicationDTO.from(medicationEntity));
        }
        MedicationListDTO medicationListDTO = new MedicationListDTO(medicationDTOList);
        return new ResponseEntity<>(medicationListDTO, HttpStatus.OK);
    }
}
