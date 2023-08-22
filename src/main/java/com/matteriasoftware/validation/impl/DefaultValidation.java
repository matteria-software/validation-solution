package com.matteriasoftware.validation.impl;

import com.matteriasoftware.validation.report.ValidationStatus;
import com.matteriasoftware.validation.Validatable;
import com.matteriasoftware.validation.configuration.Configuration;

public final class DefaultValidation extends AbstractValidation {
    public DefaultValidation(Validatable validatable, final Configuration configuration) {
        super(validatable, configuration);
    }

    @Override
    public ValidationStatus handleError(Exception e) {
        return ValidationStatus.FAILURE;
    }
}
