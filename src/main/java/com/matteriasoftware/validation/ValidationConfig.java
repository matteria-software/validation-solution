package com.matteriasoftware.validation;

public class ValidationConfig {
    private String name;

    public ValidationConfig name(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }
}
