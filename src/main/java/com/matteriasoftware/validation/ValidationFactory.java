package com.matteriasoftware.validation;

import com.matteriasoftware.validation.Validatable;
import com.matteriasoftware.validation.configuration.Configuration;
import com.matteriasoftware.validation.configuration.ConfigurationAssistant;
import com.matteriasoftware.validation.impl.CustomValidation;
import com.matteriasoftware.validation.impl.DefaultValidation;

public class ValidationFactory {
    public static DefaultValidation createDefaultValidation(final Validatable validatable) {
        final ConfigurationAssistant assistant = new ConfigurationAssistant();
        assistant.identifier(validatable.getClass().getSimpleName());
        return new DefaultValidation(validatable, assistant.build());
    }

    public static CustomValidation craeteCustomValidation(final Validatable validatable, Configuration configuration) {
        return new CustomValidation(validatable, configuration);
    }
}
