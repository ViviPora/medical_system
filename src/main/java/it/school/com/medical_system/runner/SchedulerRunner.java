package it.school.com.medical_system.runner;

import it.school.com.medical_system.schedulers.EmailScheduler;
import it.school.com.medical_system.schedulers.ReportScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRunner implements CommandLineRunner {
    @Autowired
    ReportScheduler dailyReportScheduler;
    @Autowired
    EmailScheduler emailScheduler;

    @Override
    public void run(String... args) throws Exception {

//        dailyReportScheduler.sendReportToDoctor();
//        emailScheduler.remainderAppointment();

    }
}
