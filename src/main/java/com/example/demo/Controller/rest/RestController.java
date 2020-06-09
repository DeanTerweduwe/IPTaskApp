package com.example.demo.Controller.rest;

import com.example.demo.Domain.Task;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/tasks")
public class RestController {

    private final TaskService service;

    @Autowired
    public RestController(TaskService service){
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<Task> getTasks(){
        return this.service.getTasks();
    }

    @PostMapping
    public void createTask(@RequestBody @Valid TaskDTO taskdto){

        this.service.addTask(taskdto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Task getTask(@PathVariable int id){
        return this.service.getTaskId(id);
    }

}
