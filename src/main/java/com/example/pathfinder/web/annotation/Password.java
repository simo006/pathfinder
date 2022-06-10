package com.example.pathfinder.web.annotation;

import com.example.pathfinder.web.annotation.validator.PasswordValidator;
import com.example.pathfinder.web.annotation.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {

    String message() default "password contains invalid symbols";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
