package com.matteriasoftware.validation;

import com.matteriasoftware.validation.report.ValidationReport;

import java.util.List;
import java.util.function.Consumer;

public interface Configuration {
    String identifier();
    List<Exception> allowedExceptions();
    void onError(final Consumer<ValidationReport> arg);
}
