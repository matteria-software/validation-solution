package com.matteriasoftware.validation.metainfo;

import com.matteriasoftware.validation.ValidationStatus;
import com.matteriasoftware.validation.exception.GeneralValidationException;

public class ValidationMetaInfoBuilder {
    public String name;
    public ValidationStatus status;
    public long time;
    public GeneralValidationException validationException;
    public Exception unexpectedException;

    public ValidationMetaInfo build() {
        return new ValidationMetaInfo(status, time, name, validationException);
    }
}
