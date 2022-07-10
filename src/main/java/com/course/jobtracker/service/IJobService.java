package com.course.jobtracker.service;

import com.course.jobtracker.model.Job;

import java.util.List;

public interface IJobService {
    List<Job> findAll();
    List<Job> findAllOpenJobs();
    List<Job> findAllClosedJobs();
    void save(Job job);
    void delete(Job job);
    Job findById(Long id);
    void update(Job job);
}
