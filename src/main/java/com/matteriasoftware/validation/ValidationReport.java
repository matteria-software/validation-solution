package com.matteriasoftware.validation;

import com.matteriasoftware.validation.metainfo.ValidationMetaInfo;

import java.util.List;
import java.util.function.Consumer;

public class ValidationReport {
    private final ValidationStatus generalValidationStatus;
    private final String generalMessage;
    private final long totalTime;
    private final List<ValidationMetaInfo> validationMetaInfos;

    private ValidationReport(final List<ValidationMetaInfo> validationMetaInfos,
                                final long totalTime,
                                final ValidationStatus generalValidationStatus,
                                String generalMessage) {
        this.validationMetaInfos = validationMetaInfos;
        this.totalTime = totalTime;
        this.generalValidationStatus = generalValidationStatus;
        this.generalMessage = generalMessage;
    }

    public ValidationStatus getGeneralValidationStatus() {
        return generalValidationStatus;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public List<ValidationMetaInfo> getValidationInformation() {
        return List.of(validationMetaInfos.toArray(new ValidationMetaInfo[0]));
    }

    public String getGeneralValidationMessage() {
        return this.generalMessage;
    }

    @Override
    public String toString() {
        return "ValidationReport{" +
                "validationMetaInfos=" + validationMetaInfos +
                ", totalTime=" + totalTime + " milliseconds" +
                '}';
    }

    public static ValidationReportBuilder builder() {
        return new ValidationReportBuilder();
    }

    public static class ValidationReportBuilder {
        public List<ValidationMetaInfo> validationMetaInfos;
        public long totalTime;
        public String generalMessage;
        public ValidationStatus generalValidationStatus;

        public ValidationReportBuilder with(final Consumer<ValidationReport.ValidationReportBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ValidationReport build() {
            return new ValidationReport(validationMetaInfos, totalTime, generalValidationStatus, generalMessage);
        }
    }
}
