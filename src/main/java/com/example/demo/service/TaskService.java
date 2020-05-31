package com.example.demo.service;

import com.example.demo.Domain.Task;
import com.example.demo.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

     List<Task> getTasks();

    void addTask(TaskDTO taskDTO);

    Task getTaskId(int taskId);

     void editTask(int taskId,TaskDTO taskDTO);
}
