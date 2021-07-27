package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores.UnprocesableException;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.NotNulllvalidationAnotation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.UsuarioValidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullValidation implements ConstraintValidator<NotNulllvalidationAnotation,String > {


    @Override
    public void initialize(NotNulllvalidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String campo, ConstraintValidatorContext context)throws UnprocesableException {
       if (campo!=null){
           return true;
       }
        throw new  UnprocesableException("El campo no puede ser nulo");
    }
}
