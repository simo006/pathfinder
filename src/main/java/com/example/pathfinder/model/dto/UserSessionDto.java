package com.example.pathfinder.model.dto;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.enums.LevelEnum;

import java.util.Set;

public class UserSessionDto {

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private LevelEnum level;
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public UserSessionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserSessionDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserSessionDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserSessionDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserSessionDto setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserSessionDto setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
