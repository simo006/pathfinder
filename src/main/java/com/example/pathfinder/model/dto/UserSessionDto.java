package com.example.pathfinder.model.dto;

import com.example.pathfinder.model.entity.Role;

import java.util.Set;

public class UserSessionDto {

    private Long id;
    private String username;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public UserSessionDto setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
