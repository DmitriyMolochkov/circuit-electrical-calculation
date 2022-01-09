package com.courseproject.circuitelectricalcalculation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CalculationCreateModelValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CalculationCreateModelConstraint {
    String message() default "Invalid calculation create model";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}