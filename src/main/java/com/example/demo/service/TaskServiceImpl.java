package com.example.demo.service;

import com.example.demo.Domain.Task;
import com.example.demo.dto.TaskDTO;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository){this.repository = repository;}

    @Override
    public List<Task> getTasks() {
    return  repository.getTasks();
        }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getName(),taskDTO.getDateTime(),taskDTO.getDesc());
        repository.addTask(task);
    }

    @Override
    public Task getTaskId(int taskId) {
        for (Task t:repository.getTasks() ) {
            if (t.getId() == taskId){   return t;  }
        }
        return null;
    }

    @Override
    public void editTask(int taskId,TaskDTO taskDTO) {
        for (Task t:repository.getTasks() ) {
            if (t.getId() == taskId){
                t.setDateTime(taskDTO.getDateTime());
                t.setDesc(taskDTO.getDesc());
                t.setName(taskDTO.getName());
            }
        }

    }
}
