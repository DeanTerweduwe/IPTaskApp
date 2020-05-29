package com.example.demo.Controller;


import com.example.demo.Domain.Task;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){this.taskService = taskService;}

    @GetMapping
    public String getTasks(Model  model){
        model.addAttribute("tasks",taskService.getTasks());
        return "tasks";
    }

   /* @PostMapping
    public String addTask(@ModelAttribute TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }*/

    @GetMapping("/new")
    public String addTaskPage(){
        return "newTask";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return "redirect:/";

    }

}