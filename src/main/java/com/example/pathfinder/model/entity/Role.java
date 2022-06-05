package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
