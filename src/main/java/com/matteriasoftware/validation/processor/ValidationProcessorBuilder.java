package com.matteriasoftware.validation.processor;

import com.matteriasoftware.validation.Validation;
import com.matteriasoftware.validation.Validatable;
import com.matteriasoftware.validation.ValidationFactory;

import java.util.ArrayList;
import java.util.List;

public class ValidationProcessorBuilder {
    private final List<Validation> validations = new ArrayList<>();

    public ValidationProcessorBuilder put(final Validation customValidation) {
        assert customValidation != null;
        this.validations.add(customValidation);
        return this;
    }

    public ValidationProcessorBuilder put(final Validatable validatable) {
        final Validation validation = ValidationFactory.createDefaultValidation(validatable);
        validations.add(validation);
        return this;
    }

//    public ValidationProcessorBuilder put(final Validatable validatable, final Configurable configurable) {
//        final Validation validation = ValidationFactory.craeteCustomValidation(validatable, configurable.configure(new ConfigurationAssistant()));
//        validations.add(validation);
//        return this;
//    }

    public ValidationProcessor build() {
        return new ValidationProcessor(validations);
    }
}
