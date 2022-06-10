package com.example.pathfinder.user;

import com.example.pathfinder.model.dto.UserSessionDto;
import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private Set<Role> roles;
    private String username;
    private boolean isLogged = false;
    private boolean isAdmin = false;

    public boolean isLogged() {
        return this.isLogged;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void updateData(UserSessionDto userData) throws NullPointerException {
        if (userData == null) {
            throw new NullPointerException("User session data is not valid!");
        }

        this.id = userData.getId();
        this.roles = userData.getRoles();
        this.username = userData.getUsername();

        this.isLogged = true;
        this.isAdmin = this.roles != null && this.roles.stream().anyMatch(r -> r.getRole() == RoleEnum.ADMIN);
    }

    public void eraseData() {
        this.id = null;
        this.roles = null;
        this.username = null;

        this.isLogged = false;
        this.isAdmin = false;
    }
}
