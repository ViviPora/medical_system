package it.school.com.medical_system.schedulers;

import it.school.com.medical_system.entities.AppointmentEntity;
import it.school.com.medical_system.entities.RoomEntity;
import it.school.com.medical_system.repositories.RoomRepository;
import it.school.com.medical_system.service.AppointmentService;
import it.school.com.medical_system.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class RoomAvailabilityScheduler {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;

    @Scheduled(fixedRate = 10000)
    public void roomAvailability() {

        Iterable<AppointmentEntity> appointmentEntities = this.appointmentService.findAll();
        Iterable<RoomEntity> roomEntities = this.roomService.findAll();
        for (AppointmentEntity appointment : appointmentEntities)
            for (RoomEntity room : roomEntities) {
               if(room.getRoomNumber() == appointment.getRoom().getRoomNumber() && LocalDateTime.now().isAfter(appointment.getStartAppointment()) && LocalDateTime.now().isBefore(appointment.getEndAppointment())) {
                        room.setAvailable(false);

                } else {
                    room.setAvailable(true);
                }
                roomRepository.save(room);
            }


    }
}
