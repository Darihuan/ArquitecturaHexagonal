package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.domain.Persona;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDTOInput {

    Integer id;
    String user;
    String password;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;


}
