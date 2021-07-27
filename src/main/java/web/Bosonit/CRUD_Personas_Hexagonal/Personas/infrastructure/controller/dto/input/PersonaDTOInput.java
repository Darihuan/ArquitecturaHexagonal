package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.DateValidationAnotation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.EmailvalidationAnotation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.NotNulllvalidationAnotation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.validation.UsuarioValidationAnotation;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class PersonaDTOInput {

    Integer id;
    @UsuarioValidationAnotation
    String user;

    @NotNulllvalidationAnotation(message = "el campo password no puede ser nulo")
    String password;
    @NotNulllvalidationAnotation(message = "el campo surname no puede ser nulo")
    String surname;
    @EmailvalidationAnotation(message = "El campo email personal no puede ser nulo y dede tener un formato correcto")
    String company_email;
    @EmailvalidationAnotation(message = "El campo email personal no puede ser nulo y dede tener un formato correcto")
    String personal_email;
    @NotNulllvalidationAnotation(message = "el campo city no puede ser nulo")
    String city;
    @NotNull(message = "El campo active no puede ser nulo")
    Boolean active;
    @DateValidationAnotation(message = "el campo created date no puede ser nulo ")
    Date created_Date;
    String imagen_url;
    Date termination_Date;


}
