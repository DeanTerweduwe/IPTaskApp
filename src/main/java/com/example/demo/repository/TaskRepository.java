package com.example.demo.repository;

import com.example.demo.Domain.Task;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TaskRepository {
    private List<Task> list;
    private AtomicInteger nextId = new AtomicInteger();


    public TaskRepository(){
        list = new ArrayList<>();
        list.add(new Task("Task 1", LocalDateTime.now(),"desc1",nextId.incrementAndGet()));
        list.add(new Task("Task2",LocalDateTime.of(2020,Month.MARCH,26,10,15),"desc 2",nextId.incrementAndGet()));
        list.add(new Task("Task3",LocalDateTime.of(2020,Month.SEPTEMBER,28,16,12),"desc 3",nextId.incrementAndGet()));
    }

    public List<Task> getTasks(){
        return list;
    }

    public Task getTaskByID(int id){
        for(Task t : list){
            if(t.getId()==id){
                return t;
            }
        }
        throw new IllegalArgumentException("Id not found in DB");
    }

    public void addTask(Task task){
        task.setId(nextId.incrementAndGet());
        list.add(task);
    }


}


