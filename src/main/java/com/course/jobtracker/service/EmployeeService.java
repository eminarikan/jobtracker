package com.course.jobtracker.service;

import com.course.jobtracker.model.Employee;
import com.course.jobtracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository repository;


    @Override
    public Employee findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
