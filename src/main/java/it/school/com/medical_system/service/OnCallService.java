package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.OnCallDTO;
import it.school.com.medical_system.entities.DoctorEntity;
import it.school.com.medical_system.entities.NurseEntity;
import it.school.com.medical_system.entities.OnCallEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.NurseRepository;
import it.school.com.medical_system.repositories.OnCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OnCallService {
    @Autowired
    OnCallRepository onCallRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    NurseRepository nurseRepository;

    public OnCallEntity add(OnCallDTO onCallDTO) throws InexistentResourceException {
        OnCallEntity onCallEntity = new OnCallEntity();
        Optional<DoctorEntity> doctorOptional =
                doctorRepository.findByLastNameAndFirstName(onCallDTO.getDoctorLastName(),onCallDTO.getDoctorFirstName());
        if (!doctorOptional.isPresent()){
            throw new InexistentResourceException("This doctor does not exist!", onCallDTO.getDoctorLastName(),onCallDTO.getDoctorFirstName());
        }
        Optional<NurseEntity> nurseOptional =
                nurseRepository.findByLastNameAndFirstName(onCallDTO.getNurseLastName(),onCallDTO.getNurseFirstName());
        if(!nurseOptional.isPresent()){
            throw new InexistentResourceException("This nurse does not exist!", onCallDTO.getNurseLastName(), onCallDTO.getNurseFirstName());
        }
        NurseEntity nurse = nurseOptional.get();
        DoctorEntity doctor = doctorOptional.get();
        onCallEntity.setDoctor(doctor);
        onCallEntity.setNurse(nurse);
        onCallEntity.setStarOnCall(onCallDTO.getStarOnCall());
        onCallEntity.setEndOnCall(onCallDTO.getEndOnCall());
        return onCallRepository.save(onCallEntity);
    }
       public Iterable<OnCallEntity> findAll(){
                return this.onCallRepository.findAll();
            }
    public void delete(int id) throws InexistentResourceException {
        this.onCallRepository.findById(id).orElseThrow(()-> new InexistentResourceException("Does not exist!"));
        this.onCallRepository.deleteById(id);
    }
}
