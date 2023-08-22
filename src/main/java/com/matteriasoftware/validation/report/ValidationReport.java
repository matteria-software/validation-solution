package com.matteriasoftware.validation.report;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationReport {
    private final String identifier;
    private final ValidationStatus validationStatus;
    private final List<Exception> allowedExceptions;
    private final List<Exception> foundExceptions;
    private final LocalDateTime timestamp;


    public ValidationReport(String identifier, ValidationStatus validationStatus, List<Exception> allowedExceptions,
                            List<Exception> foundExceptions, LocalDateTime timestamp) {
        this.identifier = identifier;
        this.validationStatus = validationStatus;
        this.allowedExceptions = allowedExceptions;
        this.foundExceptions = foundExceptions;
        this.timestamp = timestamp;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public List<Exception> getAllowedExceptions() {
        return allowedExceptions;
    }

    public List<Exception> getFoundExceptions() {
        return foundExceptions;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
