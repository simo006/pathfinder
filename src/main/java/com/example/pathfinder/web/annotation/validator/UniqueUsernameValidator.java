package com.example.pathfinder.web.annotation.validator;

import com.example.pathfinder.service.UserService;
import com.example.pathfinder.web.annotation.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username == null || username.isBlank() || userService.isUsernameFree(username);
    }
}
