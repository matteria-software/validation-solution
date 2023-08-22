package com.matteriasoftware.validation.processor;

import com.matteriasoftware.validation.Validation;

import java.util.List;

public class ValidationProcessor {
    private final List<Validation> customValidations;

    public ValidationProcessor(List<Validation> customValidations) {
        this.customValidations = customValidations;
    }

    public ValidatorReport validate() {
        return null;
    }

    public static ValidationProcessorBuilder builder() {
        return new ValidationProcessorBuilder();
    }
}
