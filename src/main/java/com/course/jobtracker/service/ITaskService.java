package com.course.jobtracker.service;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> findAll();
    List<Task> findByJob(Job job);
    void save(Task task);
    Task findById(Long id);
    void delete(Task task);
}
