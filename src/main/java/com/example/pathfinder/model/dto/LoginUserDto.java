package com.example.pathfinder.model.dto;

public class LoginUserDto {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public LoginUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
