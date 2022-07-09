package com.course.jobtracker.service;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findAllOpenJobs() {
        return jobRepository.findAllOpenJobs();
    }

    @Override
    public List<Job> findAllClosedJobs() {
        return jobRepository.findAllClosedJobs();
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }
}
