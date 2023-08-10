package com.matteriasoftware;

import com.matteriasoftware.validation.ValidationStatus;
import com.matteriasoftware.validation.Validator;
import com.matteriasoftware.validation.exception.GeneralValidationException;
import com.matteriasoftware.validation.ValidationReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void givenCorrectDataWithSleep_whenValidating_thenNoViolations() {
        final ValidationReport report = Validator.validate(
                (config) -> {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                (config) -> {
                    try {
                        Thread.sleep(11L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        if (report.getTotalTime() < 21L) {
            Assertions.fail();
        }
        Assertions.assertEquals(ValidationStatus.SUCCESS, report.getGeneralValidationStatus());
    }

    @Test
    public void givenIncorrectData_whenValidating_thenStatusFailed() {
        final ValidationReport report = Validator.validate(
                (config) -> { throw new GeneralValidationException("Validation Message 1"); },
                (config) -> { throw new GeneralValidationException("Validation Message 2"); }
        );
        Assertions.assertEquals("Validation Message 1, Validation Message 2", report.getGeneralValidationMessage());
        Assertions.assertEquals(ValidationStatus.FAILED, report.getGeneralValidationStatus());
    }

    @Test
    public void givenCorrectAndIncorrectData_whenValidating_thenStatusFailed() {
        final ValidationReport report = Validator.validate(
                (config) -> {},
                (config) -> { throw new GeneralValidationException("Any Validation Exception 2"); }
        );

        Assertions.assertEquals(ValidationStatus.FAILED, report.getGeneralValidationStatus());

    }

    @Test
    public void givenCorrectAndIncorrectData_whenValidating_thenStatusFailedUnexpectedAndExceptionThrown() {
        ValidationReport report = Validator.validate(
                (config) -> {

                    throw new RuntimeException("Unexpected Result");
                    },
                (config) -> { throw new GeneralValidationException("Any Validation Exception 2"); }
        );
        Assertions.assertEquals(ValidationStatus.UNEXPECTED_BEHAVIOR, report.getGeneralValidationStatus());
    }

    @Test
    public void givenIncorrectData_whenValidating_thenNameIsLikeInConfig() {
        final String name = "A Titled Validation";
        final ValidationReport report = Validator.validate(
                (config) -> {
                    config.name(name);
                    throw new RuntimeException("Unexpected Result");
                }
        );
        Assertions.assertEquals(name, report.getValidationInformation().get(0).getName());
    }
}
