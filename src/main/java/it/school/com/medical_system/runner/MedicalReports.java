package it.school.com.medical_system.runner;

import it.school.com.medical_system.schedulers.DailyReportScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MedicalReports implements CommandLineRunner {
    @Autowired
    DailyReportScheduler dailyReportScheduler;
    @Override
    public void run(String... args) throws Exception {

            dailyReportScheduler.sendReportToDoctor();

    }
}
