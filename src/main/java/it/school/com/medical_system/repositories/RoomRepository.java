package it.school.com.medical_system.repositories;

import it.school.com.medical_system.entities.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {

    RoomEntity findByRoomNumber(int roomNo);
}
