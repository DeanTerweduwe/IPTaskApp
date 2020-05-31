package com.example.demo.Domain;
import com.example.demo.dto.TaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SubTask {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String name;
    private String desc;

    public SubTask() {
    }

    public SubTask(String name, String desc) {

        this.name = name;
        this.desc = desc;
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



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }





}
