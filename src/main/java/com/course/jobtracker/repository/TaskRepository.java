package com.course.jobtracker.repository;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByJob(Job job);
}
