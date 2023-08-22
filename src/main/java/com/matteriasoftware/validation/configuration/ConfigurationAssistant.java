package com.matteriasoftware.validation.configuration;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ConfigurationAssistant {
    private String identifier;
    private List<Class<? extends Exception>> allowedExceptions;

    public ConfigurationAssistant identifier(final String identifier) {
        this.identifier = identifier;
        return this;
    }

    @SafeVarargs
    public final ConfigurationAssistant allowedExceptions(final Class<? extends Exception>... allowedExceptions) {
        this.allowedExceptions = List.of(allowedExceptions);
        return this;
    }

    public Configuration build() {
        return new Configuration(this.identifier, this.allowedExceptions);
    }
}
