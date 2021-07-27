package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores.CustomError;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores.NotFoundException;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores.UnprocesableException;

import java.util.Date;

@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<?> handleNotFoundException(NotFoundException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 404, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<?> handleNotFoundException(UnprocesableException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 422, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);

    }

}
