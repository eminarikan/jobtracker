package com.course.jobtracker.service;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.model.Task;
import com.course.jobtracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByJob(Job job) {
        return taskRepository.findByJob(job);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }
}
