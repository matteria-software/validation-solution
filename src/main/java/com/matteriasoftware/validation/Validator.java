package com.matteriasoftware.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<Exception> validate(final Validatable... validatables) {
        final List<Exception> exceptions = new ArrayList<>();
        for (final Validatable validatable : validatables) {
            try {
                validatable.run();
            } catch (final Exception e) {
                exceptions.add(e);
            }
        }
        return exceptions;
    }
}