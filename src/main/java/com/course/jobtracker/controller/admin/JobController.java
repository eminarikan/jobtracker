package com.course.jobtracker.controller.admin;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/admin/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String index(ModelMap model){
        model.addAttribute("jobs", jobService.findAll());
        model.addAttribute("jobsType", "All Jobs");
        return "admin/jobsIndex";
    }
    @GetMapping("/open")
    public String openJobs(ModelMap model){
        model.addAttribute("jobs", jobService.findAllOpenJobs());
        model.addAttribute("jobsType", "Open Jobs");
        return "admin/jobsIndex";
    }
    @GetMapping("/closed")
    public String closedJobs(ModelMap model){
        model.addAttribute("jobs", jobService.findAllClosedJobs());
        model.addAttribute("jobsType", "Closed Jobs");
        return "admin/jobsIndex";
    }

    @GetMapping("/create")
    public String create(ModelMap model){
        model.addAttribute("job", new Job());
        model.addAttribute("jobsType", "Add a Job");
        return "admin/createJob";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("job") Job job){
        job.setCreatedAt(LocalDate.now());
        jobService.save(job);
        return "redirect:/admin/jobs/";
    }
}
