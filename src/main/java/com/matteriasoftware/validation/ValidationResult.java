package com.matteriasoftware.validation;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationResult {
    private final List<Exception> exceptions;

    public ValidationResult(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    public boolean hasViolations() {
        return !exceptions.isEmpty();
    }

    public List<Exception> getExceptions() {
        return List.of(exceptions.toArray(new Exception[0]));
    }

    public String getGeneralValidationMessage() {
        return exceptions.stream().map((Throwable::getMessage)).collect(Collectors.joining(", "));
    }
    @Override
    public String toString() {
        return "ValidationResult {" +
                "exceptionList=" + exceptions +
                '}';
    }
}
