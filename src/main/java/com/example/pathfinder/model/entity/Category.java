package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.CategoryEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
