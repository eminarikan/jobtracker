package com.course.jobtracker;

import com.course.jobtracker.model.*;
import com.course.jobtracker.repository.EmployeeRepository;
import com.course.jobtracker.repository.JobRepository;
import com.course.jobtracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements ApplicationRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

            Employee admin = new Employee();
            admin.setUsername("admin");
            admin.setName("Admin1");
            admin.setPassword("123");
            admin.setRole(Constant.ADMIN);

            Employee employee = new Employee();
            employee.setUsername("user");
            employee.setName("Employee1");
            employee.setPassword("123");
            employee.setRole(Constant.EMPLOYEE);



        Job j1 = new Job();
        j1.setName("Do some stuff");
        j1.setCreatedAt(LocalDate.now());
        j1.setTargetCompletionDate(LocalDate.now().plusDays(5));
        j1.setIsOpen(false);
        j1.setProjectType(ProjectType.TYPE_A);

        Job j2 = new Job();
        j2.setName("Do some other stuff");
        j2.setCreatedAt(LocalDate.now());
        j2.setTargetCompletionDate(LocalDate.now().plusDays(10));
        j2.setIsOpen(true);
        j2.setProjectType(ProjectType.TYPE_B);


        Task t1 = new Task();
        t1.setCreatedAt(LocalDateTime.now());
        t1.setTargetCompletionDate(t1.getCreatedAt().plusDays(6));
        t1.setDescription("This is a task");
        t1.setJob(j2);
        t1.setInputBy(employee);
        t1.setPriorityLevel(PriorityLevel.HIGH);

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(t1);
        j2.setTasks(tasks);

        Task t2 = new Task();
        t2.setCreatedAt(LocalDateTime.now());
        t2.setTargetCompletionDate(t2.getCreatedAt().plusDays(6));
        t2.setDescription("This is a task");
        t2.setJob(j2);
        t2.setInputBy(employee);
        t2.setPriorityLevel(PriorityLevel.HIGH);


        employeeRepository.save(admin);
        employeeRepository.save(employee);
        jobRepository.save(j1);
        jobRepository.save(j2);
    }
}
