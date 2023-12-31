# Java Validation Solution

This is a Java-based validation solution that allows you to perform validation tasks, 
collect metadata, and generate comprehensive validation reports. The framework provides 
a structured way to handle various validation scenarios within your application.

## About Validation Statuses

In the realm of understanding validation outcomes, aligning these statuses with business processes 
provides a keen insight. Consider a successful validation as the embodiment of a smoothly executed 
operation, symbolized by the status "SUCCESS." This status signifies the accomplishment of the 
intended task without any hitches or deviations.

Conversely, the "FAILED" status stands as a sentinel for anticipated setbacks. It represents 
instances where something didn't quite align with expectations, yet the outcome is within the 
anticipated scope of validation hurdles. This status serves as an informative marker, indicating 
that the validation encountered known challenges.
that the validation encountered known challenges.

However, the true distinction emerges with the "UNEXPECTED_BEHAVIOR" status. Here, we confront 
the domain where validation encounters uncharted territory, venturing beyond the boundaries of 
mere deviations. This status signals a divergence so significant that it delves into the realm 
of unpredictability and divergence from anticipated norms.
## Examples

Here are some examples of how to use the validation framework:

``` java
// Define validation tasks
Validatable validationTask1 = (config) -> { 
   /* Your validation logic here */ 
};

Validatable validationTask2 = (config) -> {
    /* Make configurations in config */
   config.name(/* Name for this validation */);
   /* Your validation logic here */ 
};

// Validate tasks and generate a report
ValidationReport report = Validator.validate(validationTask1, validationTask2);

Assertions.assertEquals(ValidationStatus.SUCCESS, report.getGeneralValidationStatus());
```

For more examples, refer to the ValidatorTest class.

## Contributing
Contributions to this validation framework are welcome! If you find any issues or have ideas for improvements, please 
feel free to submit issues or pull requests.