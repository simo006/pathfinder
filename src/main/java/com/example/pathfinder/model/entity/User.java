package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column
    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public User setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
