package com.example.demo.Domain;
import com.example.demo.dto.TaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.security.auth.Subject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Task {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String name;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String desc;
    private List<SubTask> subTasks;

    public Task() {
        this.subTasks = new ArrayList<>();
    }

    public Task(String name, LocalDateTime dateTime, String desc) {
        this.subTasks = new ArrayList<>();

        this.name = name;
        this.dateTime = dateTime;
        this.desc = desc;
    }

    public Task(String name, LocalDateTime dateTime, String desc,int id) {
        this.subTasks = new ArrayList<>();

        this.name = name;
        this.dateTime = dateTime;
        this.desc = desc;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(SubTask subTask){
        subTasks.add(subTask);
    }
    public SubTask getSubtaskWithId(int id){
        for (SubTask s:subTasks ) {
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
}
