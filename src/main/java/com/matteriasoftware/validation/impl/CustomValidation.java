package com.matteriasoftware.validation.impl;

import com.matteriasoftware.validation.report.ValidationStatus;
import com.matteriasoftware.validation.Validatable;
import com.matteriasoftware.validation.configuration.Configuration;

public final class CustomValidation extends AbstractValidation {
    public CustomValidation(Validatable validatable, Configuration configuration) {
        super(validatable, configuration);
    }

    @Override
    public ValidationStatus handleError(Exception e) {
        if (configuration.getAllowedExceptions().isEmpty()) {

        }
        //TODO: if configuration doesnt have allowed exceptions -> make validation status = fail !first!
        ValidationStatus validationStatus = ValidationStatus.UNEXPECTED_BEHAVIOR;
        for (Class<? extends Exception> allowedException : configuration.getAllowedExceptions()) {
            if (e.getClass().equals(allowedException)) {
                validationStatus = ValidationStatus.FAILURE;
            }
        }
        return validationStatus;
    }
}
