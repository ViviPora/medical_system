package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.ProceduresDTO;
import it.school.com.medical_system.entities.ProceduresEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.ProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProceduresService {
    @Autowired
    ProceduresRepository proceduresRepository;

    public ProceduresEntity add(ProceduresDTO proceduresDTO){
        ProceduresEntity proceduresEntity = new ProceduresEntity();
        proceduresEntity.setCost(proceduresDTO.getCost());
        proceduresEntity.setName(proceduresDTO.getName());
        return proceduresRepository.save(proceduresEntity);
    }
       public Iterable<ProceduresEntity> findAll(){
                return this.proceduresRepository.findAll();
            }
    public void delete(int id) throws InexistentResourceException {
        this.proceduresRepository.findById(id).orElseThrow(() -> new InexistentResourceException("this procedure does not exist in data base"));
        this.proceduresRepository.deleteById(id);
    }
}


