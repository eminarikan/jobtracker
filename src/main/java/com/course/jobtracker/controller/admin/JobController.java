package com.course.jobtracker.controller.admin;

import com.course.jobtracker.model.Job;
import com.course.jobtracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        jobService.delete(jobService.findById(id));
        return "redirect:/admin/jobs/";
    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("job", jobService.findById(id));
        model.addAttribute("jobsType", "Job Detail");
        return "admin/jobDetail";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("job", jobService.findById(id));
        model.addAttribute("jobsType", "Edit Job");
        return "admin/editJob";
    }
    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("job") Job job){
        jobService.update(job);
        return "redirect:/admin/jobs/";
    }
}
