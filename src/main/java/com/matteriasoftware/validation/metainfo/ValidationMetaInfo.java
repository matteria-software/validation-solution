package com.matteriasoftware.validation.metainfo;

import com.matteriasoftware.validation.report.ValidationStatus;
import com.matteriasoftware.validation.exception.ValidationConfigurationException;

import java.util.Optional;

public class ValidationMetaInfo {
    private final String name;
    private final ValidationStatus status;
    private final long time;
    private final ValidationConfigurationException validationException;

    public ValidationMetaInfo(ValidationStatus status, long time, String name, ValidationConfigurationException validationException) {
        this.status = status;
        this.time = time;
        this.name = name;
        this.validationException = validationException;
    }

    public ValidationStatus getStatus() {
        return this.status;
    }

    public long getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public Optional<ValidationConfigurationException> getValidationException() {
        if (validationException == null) {
            return Optional.empty();
        }
        return Optional.of(this.validationException);
    }

    public static ValidationMetaInfoBuilder builder() {
        return new ValidationMetaInfoBuilder();
    }
}
