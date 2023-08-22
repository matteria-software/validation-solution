package com.matteriasoftware.validation;


import com.matteriasoftware.validation.impl.ValidationResult;
import com.matteriasoftware.validation.report.ValidationReport;
import com.matteriasoftware.validation.report.ValidationStatus;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Validation {
    private final Validatable validatable;
    private final Configuration configuration;

    public Validation(final Validatable validatable, final Configuration configuration) {
        this.validatable = validatable;
        this.configuration = configuration;
    }

    public abstract ValidationStatus handleError(Exception e);

    public ValidationReport validate() {
        Instant start = Instant.now();

        try {
            this.validatable.run();
        } catch (final Exception e) {
            Instant end = Instant.now();
            ValidationStatus status = handleError(e);
            final long executionTime = Duration.between(start, end).toNanos();
            return new ValidationReport(this.configuration.identifier(), status, this.configuration.allowedExceptions(),
                    List.of(e), LocalDateTime.now(), "");
        }

        Instant end = Instant.now();
        ValidationStatus status = ValidationStatus.SUCCESS;


        final long executionTime = Duration.between(start, end).toNanos();
        return null;
    }
}
