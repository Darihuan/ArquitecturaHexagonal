package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.domain.Persona;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.MostrarPersonaDTO;

import java.util.Date;

public interface Ivalidation {
    void validarPersona(Persona persona) throws Exception;

    void validateUser(String user) throws Exception;

    void validatePassword(String password) throws Exception;

    void validateSurname(String surname) throws Exception;

    void validateemail(String email) throws Exception;

    void validateCity(String city) throws Exception;

    void validateActive(Boolean active) throws Exception;

    void validateCreatedDate(Date created_Date) throws Exception;
}
