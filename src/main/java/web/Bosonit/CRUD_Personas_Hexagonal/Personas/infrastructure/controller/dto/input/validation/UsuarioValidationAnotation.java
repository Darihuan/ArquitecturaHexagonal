package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation.UserValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsuarioValidationAnotation {
    String message() default "El campo user no puede ser nulo y debe tener entre 6 y 10 caracteres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
