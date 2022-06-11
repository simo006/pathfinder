package com.example.pathfinder.model.dto;

import com.example.pathfinder.web.annotation.*;

import javax.validation.constraints.*;

@EqualPasswords
public class RegisterUserDto {

    @NotBlank
    @Size(min = 5, max = 20)
    @UniqueUsername
    @OnlyLetters
    private String username;

    @NotBlank
    @Size(min = 5, max = 20)
    @OnlyLettersAndSpaces
    private String fullName;

    @Min(0)
    @Max(90)
    private Integer age;

    @NotBlank
    @Size(min = 5)
    @Password
    private String password;

    @NotBlank
    @Size(min = 5)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public RegisterUserDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
