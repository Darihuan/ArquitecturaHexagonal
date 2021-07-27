package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores.UnprocesableException;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.EmailvalidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<EmailvalidationAnotation, String> {


    @Override
    public void initialize(EmailvalidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) throws UnprocesableException {
        if (email != null) {
            if (email.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")) {
                return true;
            }
        }
        throw new UnprocesableException("El email no tine un formato correcto o es nulo");
    }
}