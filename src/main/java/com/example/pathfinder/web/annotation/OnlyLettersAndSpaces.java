package com.example.pathfinder.web.annotation;

import com.example.pathfinder.web.annotation.validator.OnlyLettersAndSpacesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OnlyLettersAndSpacesValidator.class)
@Documented
public @interface OnlyLettersAndSpaces {

    String message() default "only letters and spaces expected";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
