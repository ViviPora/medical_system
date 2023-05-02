package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

}
