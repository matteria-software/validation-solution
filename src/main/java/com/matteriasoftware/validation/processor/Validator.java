package com.matteriasoftware.validation.processor;


/*
*   TODO: I need the validations in the format such that we expect the right exceptions for every validation rule
*       Validator
*           .putValidation(() -> { some logic }) // in this case, every violation will be treated as a FAILED STATUS,
*               and not UNEXPECTED_BEHAVIOR
*           .putValidation(() -> { some logic }, (config) -> {
*               config.identifier("Something that can better identify the validation")
*                   .allowedExceptions({ NullPointer.class, OtherBusinessExceptions.class });
*           }),
*               // in this case, every violation that will be in bounds of provided exceptions in configuration will be treated as a FAILED,
*               and others with UNEXPECTED_BEHAVIOR
*           .putValidation(new Validation()) // but validation is abstract class thats why we would need an implemetations
*           .validate();
*   TODO: there will be 3 different ways how to put validations inside the validator,
*       1.
 * */

public class Validator {
//    public static ValidatorReport validate(final Validatable... validatables) {
//        final List<ValidationMetaInfo> validationInfos = new ArrayList<>();
//
//        for (final Validatable validatable : validatables) {
//            final ValidationMetaInfoBuilder builder = processValidatableAndCreateValidationBuilder(validatable);
//            validationInfos.add(builder.build());
//        }
//
//        return ValidatorReport.builder()
//                .with($ -> {
//                    $.generalValidationStatus = determineFinalStatus(validationInfos);
//                    $.generalMessage = generalMessage(validationInfos);
//                    $.totalTime = calculateTotalTime(validationInfos);
//                    $.validationMetaInfos = validationInfos;
//                })
//                .build();
//    }
//
//    private static ValidationMetaInfoBuilder processValidatableAndCreateValidationBuilder(final Validatable validatable) {
//        final ValidationMetaInfoBuilder builder = ValidationMetaInfo.builder();
//        final ValidationConfig config = new ValidationConfig();
//
//        Instant start = Instant.now();
//        try {
//            validatable.run();
//            builder.status = ValidationStatus.SUCCESS;
//        } catch (final ValidationConfigurationException e) {
//            builder.validationException = e;
//            builder.status = ValidationStatus.FAILED;
//        } catch (final Exception exception) {
//            builder.unexpectedException = exception;
//            builder.status = ValidationStatus.UNEXPECTED_BEHAVIOR;
//        }
//        Instant end = Instant.now();
//
//        builder.time = Duration.between(start, end).toMillis();
//
//        if (config.getName() != null) {
//            builder.name = config.getName();
//        } else {
//            builder.name = validatable.getClass().getSimpleName();
//        }
//
//        return builder;
//    }
//
//    private static long calculateTotalTime(final List<ValidationMetaInfo> validationMetaInfos) {
//        return validationMetaInfos.stream().map(ValidationMetaInfo::getTime).reduce(0L, Long::sum);
//    }
//
//    private static ValidationStatus determineFinalStatus(final List<ValidationMetaInfo> validationMetaInfos) {
//        ValidationStatus status = ValidationStatus.SUCCESS;
//        for (ValidationMetaInfo validationMetaInfo : validationMetaInfos) {
//            if (validationMetaInfo.getStatus() == ValidationStatus.FAILED) {
//                status = ValidationStatus.FAILED;
//            } else if (validationMetaInfo.getStatus() == ValidationStatus.UNEXPECTED_BEHAVIOR) {
//                return ValidationStatus.UNEXPECTED_BEHAVIOR;
//            }
//        }
//        return status;
//    }
//
//    private static String generalMessage(final List<ValidationMetaInfo> validationMetaInfos) {
//        return validationMetaInfos.stream().filter(i -> i.getValidationException().isPresent())
//                .map(i -> i.getValidationException().get().getMessage()).collect(Collectors.joining(", "));
//    }
}