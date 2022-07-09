package com.course.jobtracker.service;

import com.course.jobtracker.model.Employee;
import com.course.jobtracker.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = employeeService.findByUsername(username);

        if (username == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı!");
        }

        return new MyUserDetails(user);
    }
}
