package com.matteriasoftware.validation.metainfo;

import com.matteriasoftware.validation.report.ValidationStatus;
import com.matteriasoftware.validation.exception.ValidationConfigurationException;

public class ValidationMetaInfoBuilder {
    public String name;
    public ValidationStatus status;
    public long time;
    public ValidationConfigurationException validationException;
    public Exception unexpectedException;

    public ValidationMetaInfo build() {
        return new ValidationMetaInfo(status, time, name, validationException);
    }
}
