package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.LoginUserDto;
import com.example.pathfinder.model.dto.RegisterUserDto;

public interface UserService {

    boolean register(RegisterUserDto registerUserDto);

    boolean login(LoginUserDto loginUserDto);

    void logout();

    boolean isUsernameFree(String username);
}
