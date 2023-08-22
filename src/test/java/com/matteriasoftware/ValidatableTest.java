package com.matteriasoftware;

import com.matteriasoftware.validation.Validatable;
import org.junit.jupiter.api.Test;

public class ValidatableTest {
    @Test
    public void test() {
        Validatable validatable = () -> {
            System.out.println("First block of code");
            throw new Exception("First exception");
        };

        Validatable validatable2 = () -> {
            System.out.println("Second block of code");
            throw new Exception("Second exception");
        };
    }
}
