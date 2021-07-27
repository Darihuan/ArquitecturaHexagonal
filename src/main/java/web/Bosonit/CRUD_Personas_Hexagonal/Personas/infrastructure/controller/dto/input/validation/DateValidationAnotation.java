package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation.DateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Past;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = DateValidation.class)
@Past
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValidationAnotation {
    String message() default "La fecha debe no puede ser nula y ser una fecha del pasado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
