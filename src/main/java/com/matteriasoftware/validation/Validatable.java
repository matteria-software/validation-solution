package com.matteriasoftware.validation;

/* Single basic unit that must check only one exception */
@FunctionalInterface
public interface Validatable {
    void run() throws Exception;
}
