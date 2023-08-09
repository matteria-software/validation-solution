package com.matteriasoftware;

import com.matteriasoftware.validation.ValidationException;
import com.matteriasoftware.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {
    @Test
    public void validateWithCorrectData() {
        final List<Exception> exceptions = Validator.validate(
                () -> {
                    System.out.println("Looks good");
                },
                () -> {
                    System.out.println("Looks good as well");
                }
        );
        Assertions.assertTrue(exceptions.isEmpty());
    }

    @Test
    public void validateWithIncorrectData() {
        final List<Exception> exceptions = Validator.validate(
                () -> { throw new ValidationException("Any Runtime Exception 1"); },
                () -> { throw new ValidationException("Any Runtime Exception 2"); }
        );
        Assertions.assertFalse(exceptions.isEmpty());
    }

    @Test
    public void validateWithCorrectAndIncorrectData() {
        final List<Exception> exceptions = Validator.validate(
                () -> {
                    System.out.println("Looks good");
                },
                () -> { throw new ValidationException("Any Runtime Exception 2"); }
        );
        Assertions.assertFalse(exceptions.isEmpty());
    }
}
