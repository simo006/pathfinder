package com.example.pathfinder.web.annotation;

import com.example.pathfinder.web.annotation.validator.LettersDigitsAndSpacesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LettersDigitsAndSpacesValidator.class)
@Documented
public @interface LettersDigitsAndSpaces {

    String message() default "only letters, digits and spaces expected";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
