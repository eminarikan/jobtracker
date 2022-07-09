package com.course.jobtracker.service;

import com.course.jobtracker.model.Employee;
import com.course.jobtracker.model.Job;

import java.util.List;

public interface IEmployeeService {
    Employee findByUsername(String username);

}
