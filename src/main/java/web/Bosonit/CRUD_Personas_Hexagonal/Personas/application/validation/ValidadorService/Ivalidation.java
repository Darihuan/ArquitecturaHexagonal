package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation.ValidadorService;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;

import java.util.Date;

public interface Ivalidation {
    void validarPersona(PersonaDTOInput persona) throws Exception;

    void validateUser(String user) throws Exception;

    void validatePassword(String password) throws Exception;

    void validateSurname(String surname) throws Exception;

    void validateemail(String email) throws Exception;

    void validateCity(String city) throws Exception;

    void validateActive(Boolean active) throws Exception;

    void validateCreatedDate(Date created_Date) throws Exception;
}
