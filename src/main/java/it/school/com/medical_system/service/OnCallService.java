package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.OnCallDTO;
import it.school.com.medical_system.entities.OnCallEntity;
import it.school.com.medical_system.repositories.DoctorRepository;
import it.school.com.medical_system.repositories.NurseRepository;
import it.school.com.medical_system.repositories.OnCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnCallService {
    @Autowired
    OnCallRepository onCallRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    NurseRepository nurseRepository;

    public OnCallEntity add(OnCallDTO onCallDTO) {
        OnCallEntity onCallEntity = new OnCallEntity();
        onCallEntity.setDoctor
                (doctorRepository.findByLastNameAndFirstName(onCallDTO.getDoctorLastName(),onCallDTO.getDoctorFirstName()));
        onCallEntity.setNurse
                (nurseRepository.findByLastNameAndFirstName(onCallDTO.getNurseLastName(),onCallDTO.getNurseFirstName()));
        onCallEntity.setStarOnCall(onCallDTO.getStarOnCall());
        onCallEntity.setEndOnCall(onCallDTO.getEndOnCall());
        return onCallRepository.save(onCallEntity);
    }
       public Iterable<OnCallEntity> findAll(){
                return this.onCallRepository.findAll();
            }
    public void delete(int id) {
        this.onCallRepository.deleteById(id);
    }
}
