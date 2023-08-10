package com.matteriasoftware.validation;

import com.matteriasoftware.validation.exception.GeneralValidationException;
import com.matteriasoftware.validation.metainfo.ValidationMetaInfo;
import com.matteriasoftware.validation.metainfo.ValidationMetaInfoBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static ValidationReport validate(final Validatable... validatables) {
        final List<ValidationMetaInfo> validationInfos = new ArrayList<>();

        for (final Validatable validatable : validatables) {
            final ValidationMetaInfoBuilder builder = processValidatableAndCreateValidationBuilder(validatable);
            validationInfos.add(builder.build());
        }

        return ValidationReport.builder()
                .with($ -> {
                    $.generalValidationStatus = determineFinalStatus(validationInfos);
                    $.generalMessage = generalMessage(validationInfos);
                    $.totalTime = calculateTotalTime(validationInfos);
                    $.validationMetaInfos = validationInfos;
                })
                .build();
    }

    private static ValidationMetaInfoBuilder processValidatableAndCreateValidationBuilder(final Validatable validatable) {
        final ValidationMetaInfoBuilder builder = ValidationMetaInfo.builder();
        final ValidationConfig config = new ValidationConfig();

        Instant start = Instant.now();
        try {
            validatable.run(config);
            builder.status = ValidationStatus.SUCCESS;
        } catch (final GeneralValidationException e) {
            builder.validationException = e;
            builder.status = ValidationStatus.FAILED;
        } catch (final Exception exception) {
            builder.unexpectedException = exception;
            builder.status = ValidationStatus.UNEXPECTED_BEHAVIOR;
        }
        Instant end = Instant.now();

        builder.time = Duration.between(start, end).toMillis();

        if (config.getName() != null) {
            builder.name = config.getName();
        } else {
            builder.name = validatable.getClass().getSimpleName();
        }

        return builder;
    }

    private static long calculateTotalTime(final List<ValidationMetaInfo> validationMetaInfos) {
        return validationMetaInfos.stream().map(ValidationMetaInfo::getTime).reduce(0L, Long::sum);
    }

    private static ValidationStatus determineFinalStatus(final List<ValidationMetaInfo> validationMetaInfos) {
        ValidationStatus status = ValidationStatus.SUCCESS;
        for (ValidationMetaInfo validationMetaInfo : validationMetaInfos) {
            if (validationMetaInfo.getStatus() == ValidationStatus.FAILED) {
                status = ValidationStatus.FAILED;
            } else if (validationMetaInfo.getStatus() == ValidationStatus.UNEXPECTED_BEHAVIOR) {
                return ValidationStatus.UNEXPECTED_BEHAVIOR;
            }
        }
        return status;
    }

    private static String generalMessage(final List<ValidationMetaInfo> validationMetaInfos) {
        return validationMetaInfos.stream().filter(i -> i.getValidationException().isPresent())
                .map(i -> i.getValidationException().get().getMessage()).collect(Collectors.joining(", "));
    }
}