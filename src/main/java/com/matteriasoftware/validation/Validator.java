package com.matteriasoftware.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<Exception> validate(final ValidationTask... tasks) {
        final List<Exception> exceptions = new ArrayList<>();
        for (final ValidationTask task : tasks) {
            try {
                task.run();
            } catch (final ValidationException e) {
                exceptions.add(e);
            }
        }
        return exceptions;
    }
}