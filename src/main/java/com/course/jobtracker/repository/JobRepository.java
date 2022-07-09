package com.course.jobtracker.repository;

import com.course.jobtracker.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("from Job where isOpen = true")
    List<Job> findAllOpenJobs();

    @Query("from Job where isOpen = false")
    List<Job> findAllClosedJobs();
}
