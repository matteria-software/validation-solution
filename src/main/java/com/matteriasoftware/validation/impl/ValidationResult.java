package com.matteriasoftware.validation.impl;

import com.matteriasoftware.validation.report.ValidationStatus;
import com.matteriasoftware.validation.Validation;

public class ValidationResult {
    private final Validation validation;
    private final ValidationStatus status;
    private final Exception exception;
    private final long executionTime;

    public ValidationResult(final Validation validation, final ValidationStatus status,
                            final Exception exception, final long executionTime) {
        assert validation != null;
        assert status != null;
        assert executionTime >= 0;
        this.validation = validation;
        this.status = status;
        this.exception = exception;
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "ValidationResult {" +
                "validation=" + validation +
                ", status=" + status +
                ", optionalException=" + exception +
                ", executionTime=" + executionTime +
                '}';
    }
}
