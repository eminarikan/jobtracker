package com.course.jobtracker;

import com.course.jobtracker.model.Constant;
import com.course.jobtracker.model.Employee;
import com.course.jobtracker.model.Job;
import com.course.jobtracker.model.ProjectType;
import com.course.jobtracker.repository.EmployeeRepository;
import com.course.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseSeeder implements ApplicationRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (employeeRepository.findAll().size() == 0){
            Employee admin = new Employee();
            admin.setUsername("admin");
            admin.setPassword("123");
            admin.setRole(Constant.ADMIN);

            Employee employee = new Employee();
            employee.setUsername("user");
            employee.setPassword("123");
            employee.setRole(Constant.EMPLOYEE);

            employeeRepository.save(admin);
            employeeRepository.save(employee);
        }
        Job j1 = new Job();
        j1.setName("Do some stuff");
        j1.setCreatedAt(LocalDate.now());
        j1.setTargetCompletionDate(LocalDate.now().plusDays(5));
        j1.setOpen(false);
        j1.setProjectType(ProjectType.TYPE_A);

        Job j2 = new Job();
        j2.setName("Do some other stuff");
        j2.setCreatedAt(LocalDate.now());
        j2.setTargetCompletionDate(LocalDate.now().plusDays(10));
        j2.setOpen(true);
        j2.setProjectType(ProjectType.TYPE_B);

        jobRepository.save(j1);
        jobRepository.save(j2);
    }
}
