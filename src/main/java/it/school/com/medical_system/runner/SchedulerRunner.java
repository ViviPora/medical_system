package it.school.com.medical_system.runner;

import it.school.com.medical_system.schedulers.EmailScheduler;
import it.school.com.medical_system.schedulers.ReportScheduler;
import it.school.com.medical_system.schedulers.RoomAvailabilityScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRunner implements CommandLineRunner {
    @Autowired
    ReportScheduler dailyReportScheduler;
    @Autowired
    EmailScheduler emailScheduler;
    @Autowired
    RoomAvailabilityScheduler roomAvailabilityScheduler;

    @Override
    public void run(String... args) throws Exception {
        roomAvailabilityScheduler.roomAvailability();
//        dailyReportScheduler.sendReportToDoctor();
//        emailScheduler.remainderAppointment();

    }
}
