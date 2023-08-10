package com.matteriasoftware.validation;

import com.matteriasoftware.validation.ValidationConfig;
import com.matteriasoftware.validation.exception.GeneralValidationException;

@FunctionalInterface
public interface Validatable {
    void run(final ValidationConfig config) throws GeneralValidationException;
}
