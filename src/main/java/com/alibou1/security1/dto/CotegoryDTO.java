package com.alibou1.security1.dto;


import com.alibou1.security1.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CotegoryDTO {

    private int id;

    private String name;

    private String title;

    private String description;

    private String experience;

    private String salary;

    private String wanted;

    private String type;

    public CotegoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.title = category.getTitle();
        this.description = category.getDescription();
        this.experience = category.getExperience();
        this.salary = category.getSalary();
        this.wanted = category.getWanted();
        this.type = category.getType();
    }


}