package com.example.pathfinder.web.annotation;


import com.example.pathfinder.web.annotation.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface UniqueUsername {

    String message() default "username already taken";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
