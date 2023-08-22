# Java Validation Solution

This is a Java-based customValidation solution that allows you to perform customValidation tasks, 
collect metadata, and generate comprehensive customValidation reports. The framework provides 
a structured way to handle various customValidation scenarios within your application.

## About Validation Statuses

In the realm of understanding customValidation outcomes, aligning these statuses with business processes 
provides a keen insight. Consider a successful customValidation as the embodiment of a smoothly executed 
operation, symbolized by the status "SUCCESS." This status signifies the accomplishment of the 
intended task without any hitches or deviations.

Conversely, the "FAILED" status stands as a sentinel for anticipated setbacks. It represents 
instances where something didn't quite align with expectations, yet the outcome is within the 
anticipated scope of customValidation hurdles. This status serves as an informative marker, indicating 
that the customValidation encountered known challenges.
that the customValidation encountered known challenges.

However, the true distinction emerges with the "UNEXPECTED_BEHAVIOR" status. Here, we confront 
the domain where customValidation encounters uncharted territory, venturing beyond the boundaries of 
mere deviations. This status signals a divergence so significant that it delves into the realm 
of unpredictability and divergence from anticipated norms.
## Examples

Here are some examples of how to use the customValidation framework:

``` java
// Define customValidation tasks
Validatable validationTask1 = (config) -> { 
   /* Your customValidation logic here */ 
};

Validatable validationTask2 = (config) -> {
    /* Make configurations in config */
   config.name(/* Name for this customValidation */);
   /* Your customValidation logic here */ 
};

// Validate tasks and generate a report
ValidationReport report = Validator.validate(validationTask1, validationTask2);

Assertions.assertEquals(ValidationStatus.SUCCESS, report.getGeneralValidationStatus());
```

For more examples, refer to the ValidatorTest class.

## Contributing
Contributions to this customValidation framework are welcome! If you find any issues or have ideas for improvements, please 
feel free to submit issues or pull requests.