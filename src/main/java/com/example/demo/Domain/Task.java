package com.example.demo.Domain;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class Task {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty(message = "Name is empty")
    private String name;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String desc;

    public Task() {
    }

    public Task(String name, LocalDateTime dateTime, String desc) {
        this.name = name;
        this.dateTime = dateTime;
        this.desc = desc;
    }

    public Task(String name, LocalDateTime dateTime, String desc,int id) {
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
}
