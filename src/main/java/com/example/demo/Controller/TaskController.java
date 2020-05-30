package com.example.demo.Controller;


import com.example.demo.Domain.Task;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addTaskPage(Model model){
        model.addAttribute("taskdto",new TaskDTO());
        return "newTask";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute("taskdto") @Valid TaskDTO taskdto, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            return "newTask";
        }
        taskService.addTask(taskdto);
        return "redirect:/";
    }






    @GetMapping("/{id}")
    public String detailTask(@PathVariable int id, Model model){
        String error = "";
        try {
            Task task = this.taskService.getTaskId(id);
            model.addAttribute("task",task);
            return "taskDetail";
        }
        catch (NumberFormatException e){
            error = id + " is not a valid ID!";
        }
        model.addAttribute("error",error);
        return "erroruser";
    }



}