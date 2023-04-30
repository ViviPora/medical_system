package it.school.com.medical_system.controllers;

import it.school.com.medical_system.dtos.*;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.repositories.HistoryRepository;
import it.school.com.medical_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminResource {
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

    @PostMapping("/admin")
    public ResponseEntity<AdminEntity> create(@RequestBody AdminEntity admin) {
        AdminEntity adminEntity = this.adminService.add(admin);
        return new ResponseEntity<>(adminEntity, HttpStatus.CREATED);

    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO doctorDTO) {
        DoctorEntity doctorEntity = this.doctorService.add(doctorDTO);
        return new ResponseEntity<>(DoctorDTO.from(doctorEntity), HttpStatus.CREATED);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO) {
        PatientEntity patientEntity = this.patientService.add(patientDTO);
        return new ResponseEntity<>(PatientDTO.from(patientEntity), HttpStatus.CREATED);
    }

    @PostMapping("/nurse")
    public ResponseEntity<NurseDTO> create(@RequestBody NurseDTO nurseDTO) {
        NurseEntity nurseEntity = this.nurseService.add(nurseDTO);
        return new ResponseEntity<>(NurseDTO.from(nurseEntity), HttpStatus.CREATED);
    }

    @PostMapping("/room")
    public ResponseEntity<RoomDTO> create(@RequestBody RoomDTO roomDTO) {
        RoomEntity roomEntity = this.roomService.add(roomDTO);
        return new ResponseEntity<>(RoomDTO.from(roomEntity), HttpStatus.CREATED);
    }

    @PostMapping("/procedures")
    public ResponseEntity<ProceduresDTO> create(@RequestBody ProceduresDTO proceduresDTO) {
        ProceduresEntity proceduresEntity = this.proceduresService.add(proceduresDTO);
        return new ResponseEntity<>(proceduresDTO.from(proceduresEntity), HttpStatus.CREATED);
    }

    @PostMapping("/medication")
    public ResponseEntity<MedicationDTO> create(@RequestBody MedicationDTO medicationDTO) {
        MedicationEntity medicationEntity = this.medicationService.add(medicationDTO);
        return new ResponseEntity<>(medicationDTO.from(medicationEntity), HttpStatus.CREATED);

    }

  @PostMapping("/history")
    public ResponseEntity<HistoryDTO> create(@RequestBody HistoryDTO historyDTO) {
        HistoryEntity historyEntity = this.historyService.add(historyDTO);
        return new ResponseEntity<>(historyDTO.from(historyEntity), HttpStatus.CREATED);

    }

    @PostMapping("/prescription")
    public ResponseEntity<PrescriptionDTO> create(@RequestBody PrescriptionDTO prescriptionDTO){
        PrescriptionEntity prescriptionEntity = this.prescriptionService.add(prescriptionDTO);
        return new ResponseEntity<>(prescriptionDTO.from(prescriptionEntity), HttpStatus.CREATED);
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = this.appointmentService.add(appointmentDTO);
        return new ResponseEntity<>(appointmentDTO.from(appointmentEntity), HttpStatus.CREATED);
    }
}
