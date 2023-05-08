package it.school.com.medical_system.service;

import it.school.com.medical_system.dtos.RoomDTO;
import it.school.com.medical_system.entities.RoomEntity;
import it.school.com.medical_system.exception.InexistentResourceException;
import it.school.com.medical_system.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public RoomEntity add(RoomDTO roomDTO) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomNumber(roomDTO.getNumber());
        roomEntity.setRoomType(roomDTO.getRoomType());
        roomEntity.setAvailable(roomDTO.isAvailable());

        return roomRepository.save(roomEntity);
    }

    public Iterable<RoomEntity> findAll() {
        return this.roomRepository.findAll();
    }

    public void delete(int id) throws InexistentResourceException {
        this.roomRepository.findById(id).orElseThrow(() -> new InexistentResourceException("This room does not exist, room id:"));
            this.roomRepository.deleteById(id);

    }
}
