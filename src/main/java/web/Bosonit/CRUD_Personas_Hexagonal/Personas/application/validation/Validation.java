package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation;

import org.springframework.stereotype.Component;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;

import java.util.Date;

@Component
public class Validation implements Ivalidation {


    @Override
    public void validarPersona(PersonaDTOInput persona) throws Exception {
        validateUser(persona.getUser());
        validatePassword(persona.getPassword());
        validateSurname(persona.getSurname());
        validateemail(persona.getCompany_email());
        validateemail(persona.getPersonal_email());
        validateCity(persona.getCity());
        validateActive(persona.getActive());
        validateCreatedDate(persona.getCreated_Date());


    }


    public void validateUser(String user) throws Exception {
        if (user != null) {
            int userlength = user.length();
            if (userlength < 6 || userlength > 10) {
                throw new Exception("Campo usuario no cumple con especificaciones de largo");
            }
        } else {
            throw new Exception("Campo usuario nulo");
        }

    }

    public void validatePassword(String password) throws Exception {
        if (password == null) throw new Exception("Campo password nulo");
    }

    public void validateSurname(String surname) throws Exception {
        if (surname == null) throw new Exception(" Campo Surname nulo");
    }

    public void validateemail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$"))
                throw new Exception("Formato de email no valido");

        } else {
            throw new Exception(" Campo Surname nulo");
        }

    }

    public void validateCity(String city) throws Exception {
        if (city == null) throw new Exception(" Campo city nulo");
    }

    public void validateActive(Boolean active) throws Exception {
        if (active == null) throw new Exception(" Campo active nulo");
    }

    public void validateCreatedDate(Date created_Date) throws Exception {
        if (created_Date == null) throw new Exception(" Campo created_date nulo");
    }
}
