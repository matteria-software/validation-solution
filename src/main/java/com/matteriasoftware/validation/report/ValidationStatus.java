package com.matteriasoftware.validation.report;

public enum ValidationStatus {
    /* The status must be taken only if the validation has no errors */
    SUCCESS,
    /* The status must be used only if an expected exception was found */
    FAILURE,
    /* The status must be used only if the validation encountered an unexpected exception */
    UNEXPECTED_BEHAVIOR;
}
