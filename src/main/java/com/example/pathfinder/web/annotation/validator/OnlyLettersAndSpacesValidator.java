package com.example.pathfinder.web.annotation.validator;

import com.example.pathfinder.web.annotation.OnlyLettersAndSpaces;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyLettersAndSpacesValidator implements ConstraintValidator<OnlyLettersAndSpaces, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^[a-zа-я ]*$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(value);

        return value == null || value.isBlank() || matcher.matches();
    }
}
