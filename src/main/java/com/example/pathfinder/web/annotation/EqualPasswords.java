package com.example.pathfinder.web.annotation;

import com.example.pathfinder.web.annotation.validator.EqualPasswordsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualPasswordsValidator.class)
@Documented
public @interface EqualPasswords {

    String message() default "passwords do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}