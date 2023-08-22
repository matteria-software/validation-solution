package com.matteriasoftware;

import com.matteriasoftware.validation.processor.ValidationProcessor;
import com.matteriasoftware.validation.Validatable;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidatorTest {
    private static final Logger logger = Logger.getLogger("ValidatorTest");
    public final Validatable successValidatable = () -> {
        logger.log(Level.INFO, "Successful empty Login");
    };

    @Test
    public void givenCorrectDataWithSleep_whenValidating_thenNoViolations() {
        ValidationProcessor.builder()
                .put(successValidatable)
                .build()
                .validate();

    }
//
//    @Test
//    public void givenCorrectDataWithSleep_whenValidating_thenNoViolations() {
//        final ValidatorReport report = Validator.validate(
//                (config) -> {
//                    try {
//                        Thread.sleep(10L);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                },
//                (config) -> {
//                    try {
//                        Thread.sleep(11L);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        );
//        if (report.getTotalTime() < 21L) {
//            Assertions.fail();
//        }
//        Assertions.assertEquals(ValidationStatus.SUCCESS, report.getGeneralValidationStatus());
//    }
//
//    @Test
//    public void givenIncorrectData_whenValidating_thenStatusFailed() {
//        final ValidatorReport report = Validator.validate(
//                (config) -> { throw new GeneralValidationException("Validation Message 1"); },
//                (config) -> { throw new GeneralValidationException("Validation Message 2"); }
//        );
//        Assertions.assertEquals("Validation Message 1, Validation Message 2", report.getGeneralValidationMessage());
//        Assertions.assertEquals(ValidationStatus.FAILED, report.getGeneralValidationStatus());
//    }
//
//    @Test
//    public void givenCorrectAndIncorrectData_whenValidating_thenStatusFailed() {
//        final ValidatorReport report = Validator.validate(
//                (config) -> {},
//                (config) -> { throw new GeneralValidationException("Any Validation Exception 2"); }
//        );
//
//        Assertions.assertEquals(ValidationStatus.FAILED, report.getGeneralValidationStatus());
//
//    }
//
//    @Test
//    public void givenCorrectAndIncorrectData_whenValidating_thenStatusFailedUnexpectedAndExceptionThrown() {
//        ValidatorReport report = Validator.validate(
//                (config) -> {
//
//                    throw new RuntimeException("Unexpected Result");
//                    },
//                (config) -> { throw new GeneralValidationException("Any Validation Exception 2"); }
//        );
//        Assertions.assertEquals(ValidationStatus.UNEXPECTED_BEHAVIOR, report.getGeneralValidationStatus());
//    }
//
//    @Test
//    public void givenIncorrectData_whenValidating_thenNameIsLikeInConfig() {
//        final String name = "A Titled Validation";
//        final ValidatorReport report = Validator.validate(
//                (config) -> {
//                    config.name(name);
//                    throw new RuntimeException("Unexpected Result");
//                }
//        );
//        Assertions.assertEquals(name, report.getValidationInformation().get(0).getName());
//    }
//
//    @Test
//    public void givenData_whenValidating_thenNameIsLikeInConfig() {
//    }
}
