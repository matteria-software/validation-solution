package com.matteriasoftware.validation.configuration;

import java.util.List;

public class Configuration {
    private String identifier;
    private List<Class<? extends Exception>> allowedExceptions;

    public Configuration(final String identifier, final List<Class<? extends Exception>> allowedExceptions) {
        this.identifier = identifier;
        this.allowedExceptions = allowedExceptions != null ? allowedExceptions : List.of();
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public List<Class<? extends Exception>> getAllowedExceptions() {
        return this.allowedExceptions;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setAllowedExceptions(List<Class<? extends Exception>> allowedExceptions) {
        this.allowedExceptions = allowedExceptions;
    }
}
