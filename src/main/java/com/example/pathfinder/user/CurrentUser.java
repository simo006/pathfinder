package com.example.pathfinder.user;

import com.example.pathfinder.model.dto.UserSessionDto;
import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.enums.LevelEnum;
import com.example.pathfinder.model.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private LevelEnum level;
    private Set<Role> roles;
    private boolean isLogged = false;
    private boolean isAdmin = false;

    public boolean isLogged() {
        return this.isLogged;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void updateData(UserSessionDto userData) throws NullPointerException {
        if (userData == null) {
            throw new NullPointerException("User session data is not valid!");
        }

        this.id = userData.getId();
        this.username = userData.getUsername();
        this.fullName = userData.getFullName();
        this.age = userData.getAge();
        this.level = userData.getLevel();
        this.roles = userData.getRoles();

        this.isLogged = true;
        this.isAdmin = this.roles != null && this.roles.stream().anyMatch(r -> r.getRole() == RoleEnum.ADMIN);
    }

    public void eraseData() {
        this.id = null;
        this.username = null;
        this.fullName = null;
        this.age = null;
        this.level = null;
        this.roles = null;

        this.isLogged = false;
        this.isAdmin = false;
    }
}
