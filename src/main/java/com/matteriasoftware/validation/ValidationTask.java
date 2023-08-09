package com.matteriasoftware.validation;

@FunctionalInterface
public interface ValidationTask {
    void run() throws ValidationException;
}
