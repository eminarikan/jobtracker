package com.course.jobtracker.controller;

import com.course.jobtracker.model.Employee;
import com.course.jobtracker.model.Job;
import com.course.jobtracker.model.MyUserDetails;
import com.course.jobtracker.model.Task;
import com.course.jobtracker.service.EmployeeService;
import com.course.jobtracker.service.JobService;
import com.course.jobtracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/jobs/{id}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String index(ModelMap model, @RequestParam("jobId") Long jobId){
        model.addAttribute("tasks", taskService.findByJob(jobService.findById(jobId)));
        model.addAttribute("tasksType", "All Tasks");
        model.addAttribute("page", "indexTask");
        return "app";
    }
    @GetMapping("/create")
    public String create(ModelMap model, @PathVariable("id") Long jobId){
        model.addAttribute("task", new Task());
        model.addAttribute("jobId", jobId);
        model.addAttribute("tasksType", "Add a Task ");
        model.addAttribute("page", "createTask");
        return "app";
    }
    @PostMapping("/create")
    public String save(
            @PathVariable("id") Long jobId,
            @ModelAttribute("task") Task task){
        task.setCreatedAt(LocalDateTime.now());
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        task.setInputBy(employeeService.findById(user.getId()));
        Job job =  jobService.findById(jobId);
        task.setJob(job);
        task.setId(0L);
        job.getTasks().add(task);
        jobService.save(job);
        return "redirect:/jobs/"+jobId+"/show";
    }

    @GetMapping("/{taskId}/delete")
    public String delete(
            @PathVariable("id") Long jobId,
            @PathVariable("taskId") Long taskId
    ){
        Task task = taskService.findById(taskId);
        taskService.delete(task);
        return "redirect:/jobs/"+jobId+"/show";
    }
}
