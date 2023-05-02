package it.school.com.medical_system.controllers;

import it.school.com.medical_system.dtos.*;
import it.school.com.medical_system.entities.*;
import it.school.com.medical_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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

    //POST - > ALL
    @PostMapping("/admin")
    public ResponseEntity<AdminEntity> create(@RequestBody AdminEntity admin) {
        AdminEntity adminEntity = this.adminService.add(admin);
        return new ResponseEntity<>(adminEntity, HttpStatus.CREATED);

    }

    @PostMapping("/person")
    public ResponseEntity<PersonEntity> create(@RequestBody PersonDTO person) {
        PersonEntity personEntity = this.personService.add(person);
        return new ResponseEntity<>(personEntity, HttpStatus.CREATED);

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
    public ResponseEntity<PrescriptionDTO> create(@RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionEntity prescriptionEntity = this.prescriptionService.add(prescriptionDTO);
        return new ResponseEntity<>(prescriptionDTO.from(prescriptionEntity), HttpStatus.CREATED);
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentEntity appointmentEntity = this.appointmentService.add(appointmentDTO);
        return new ResponseEntity<>(appointmentDTO.from(appointmentEntity), HttpStatus.CREATED);
    }

    @PostMapping("/address")
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) {
        AddressEntity addressEntity = this.addressService.add(addressDTO);
        return new ResponseEntity<>(addressDTO.from(addressEntity), HttpStatus.CREATED);
    }

    @PostMapping("/histoypatient")
    public ResponseEntity<HistoryPatientDTO> create(@RequestBody HistoryPatientDTO historyPatientDTO) {
        this.historyPatientService.addHistory(historyPatientDTO);
        return new ResponseEntity<>(historyPatientDTO, HttpStatus.CREATED);
    }

    @PostMapping("/oncall")
    public ResponseEntity<OnCallDTO> create(@RequestBody OnCallDTO onCallDTO) {
        OnCallEntity onCallEntity = this.onCallService.add(onCallDTO);
        return new ResponseEntity<>(onCallDTO.from(onCallEntity), HttpStatus.CREATED);
    }

    @PostMapping("/patientprocedures")
    public ResponseEntity<PatientProceduresDTO> create(@RequestBody PatientProceduresDTO patientProceduresDTO) {
        PatientProceduresEntity patientProceduresEntity = this.patientProceduresService.add(patientProceduresDTO);
        return new ResponseEntity<>(patientProceduresDTO.from(patientProceduresEntity), HttpStatus.CREATED);
    }

    //GET - ALL
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

    @GetMapping("/patient")
    public ResponseEntity<PatientListDTO> getAllPatient() {
        Iterable<PatientEntity> patients = this.patientService.findAll();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (PatientEntity patientEntity : patients) {
            patientDTOList.add(PatientDTO.from(patientEntity));
        }
        PatientListDTO patientListDTO = new PatientListDTO(patientDTOList);
        return new ResponseEntity<>(patientListDTO, HttpStatus.OK);
    }

    @GetMapping("/addresses")
    public ResponseEntity<AddressListDTO> getAllAddress() {
        Iterable<AddressEntity> addresses = this.addressService.findAll();
        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (AddressEntity addressEntity : addresses) {
            addressDTOList.add(AddressDTO.from(addressEntity));
        }
        AddressListDTO addressListDTO = new AddressListDTO(addressDTOList);
        return new ResponseEntity<>(addressListDTO, HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentListDTO> getAllAppointment() {
        Iterable<AppointmentEntity> appointments = this.appointmentService.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        for (AppointmentEntity appointmentEntity : appointments) {
            appointmentDTOList.add(AppointmentDTO.from(appointmentEntity));
        }
        AppointmentListDTO appointmentListDTO = new AppointmentListDTO(appointmentDTOList);
        return new ResponseEntity<>(appointmentListDTO, HttpStatus.OK);
    }
    @GetMapping("/history")
    public ResponseEntity<HistoryListDTO> getAllHistory() {
        Iterable<HistoryEntity> history = this.historyService.findAll();
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (HistoryEntity historyEntity : history) {
            historyDTOList.add(HistoryDTO.from(historyEntity));
        }
        HistoryListDTO historyListDTO = new HistoryListDTO(historyDTOList);
        return new ResponseEntity<>(historyListDTO, HttpStatus.OK);
    }

    //toDO historyPATIENT


    @GetMapping("/medication")
    public ResponseEntity<MedicationListDTO> getAllMeidcation() {
        Iterable<MedicationEntity> medication = this.medicationService.findAll();
        List<MedicationDTO> medicationDTOList = new ArrayList<>();
        for (MedicationEntity medicationEntity : medication) {
            medicationDTOList.add(MedicationDTO.from(medicationEntity));
        }
        MedicationListDTO medicationListDTO = new MedicationListDTO(medicationDTOList);
        return new ResponseEntity<>(medicationListDTO, HttpStatus.OK);
    }

    @GetMapping("/nurse")
    public ResponseEntity<NurseListDTO> getAllNurse() {
        Iterable<NurseEntity> nurses = this.nurseService.findAll();
        List<NurseDTO> nurseDTOList = new ArrayList<>();
        for (NurseEntity nurseEntity : nurses) {
            nurseDTOList.add(NurseDTO.from(nurseEntity));
        }
        NurseListDTO nurseListDTO = new NurseListDTO(nurseDTOList);
        return new ResponseEntity<>(nurseListDTO, HttpStatus.OK);
    }
    @GetMapping("/oncall")
    public ResponseEntity<OnCallListDTO> getAllOnCall() {
        Iterable<OnCallEntity> onCalls = this.onCallService.findAll();
        List<OnCallDTO> onCallDTOList = new ArrayList<>();
        for (OnCallEntity onCallEntity : onCalls) {
            onCallDTOList.add(OnCallDTO.from(onCallEntity));
        }
        OnCallListDTO onCallListDTO = new OnCallListDTO(onCallDTOList);
        return new ResponseEntity<>(onCallListDTO, HttpStatus.OK);
    }
    @GetMapping("/patientprocedures")
    public ResponseEntity<PatientProceduresListDTO> getAllPatientProcedures() {
        Iterable<PatientProceduresEntity> patientProcedures = this.patientProceduresService.findAll();
        List<PatientProceduresDTO> patientProceduresDTOList = new ArrayList<>();
        for (PatientProceduresEntity patientProceduresEntity : patientProcedures) {
            patientProceduresDTOList.add(PatientProceduresDTO.from(patientProceduresEntity));
        }
        PatientProceduresListDTO patientProceduresListDTO = new PatientProceduresListDTO(patientProceduresDTOList);
        return new ResponseEntity<>(patientProceduresListDTO, HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<PersonListDTO> getAllPerson() {
        Iterable<PersonEntity> personProcedures = this.personService.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (PersonEntity personEntity : personProcedures) {
            personDTOList.add(PersonDTO.from(personEntity));
        }
        PersonListDTO personListDTO = new PersonListDTO(personDTOList);
        return new ResponseEntity<>(personListDTO, HttpStatus.OK);
    }

    @GetMapping("/prescription")
    public ResponseEntity<PrescriptionListDTO> getAllPrescription() {
        Iterable<PrescriptionEntity> prescriptions = this.prescriptionService.findAll();
        List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();
        for (PrescriptionEntity prescriptionEntity : prescriptions) {
            prescriptionDTOList.add(PrescriptionDTO.from(prescriptionEntity));
        }
        PrescriptionListDTO prescriptionListDTO = new PrescriptionListDTO(prescriptionDTOList);
        return new ResponseEntity<>(prescriptionListDTO, HttpStatus.OK);
    }

    @GetMapping("/procedures")
    public ResponseEntity<ProceduresListDTO> getAllProcedures() {
        Iterable<ProceduresEntity> procedures = this.proceduresService.findAll();
        List<ProceduresDTO> proceduresDTOList = new ArrayList<>();
        for (ProceduresEntity proceduresEntity : procedures) {
            proceduresDTOList.add(ProceduresDTO.from(proceduresEntity));
        }
        ProceduresListDTO proceduresListDTO = new ProceduresListDTO(proceduresDTOList);
        return new ResponseEntity<>(proceduresListDTO, HttpStatus.OK);
    }

    @GetMapping("/room")
    public ResponseEntity<RoomListDTO> getAllRoom() {
        Iterable<RoomEntity> rooms = this.roomService.findAll();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (RoomEntity roomEntity : rooms) {
            roomDTOList.add(RoomDTO.from(roomEntity));
        }
        RoomListDTO roomListDTO = new RoomListDTO(roomDTOList);
        return new ResponseEntity<>(roomListDTO, HttpStatus.OK);
    }
    //DELETE - ALL
    @DeleteMapping("doctor/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") int id) {
        this.doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") int id) {
        this.addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("admin/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") int id) {
        this.adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("appointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") int id) {
        this.appointmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("history/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable("id") int id) {
        this.historyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("medication/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable("id") int id) {
        this.medicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("nurse/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable("id") int id) {
        this.nurseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("oncall/{id}")
    public ResponseEntity<Void> deleteOnCall(@PathVariable("id") int id) {
        this.onCallService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //todo
//    @DeleteMapping("patientprocedures/{id}")
//    public ResponseEntity<Void> deletePatientProcedures(@PathVariable("id") int id) {
//        this.patientProceduresService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    @DeleteMapping("patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") int id) {
        this.patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
        this.personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //TODO - delete la prescription nu fuctioneaza PK compusa, trbuie sa dai mai mult de un ID - trebuie modificat si in service si creat metodata DeletBy in repository
    @DeleteMapping("prescription/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable("id") int id) {
        this.prescriptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("procedures/{id}")
    public ResponseEntity<Void> deleteProcedures(@PathVariable("id") int id) {
        this.proceduresService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("room/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") int id) {
        this.roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
