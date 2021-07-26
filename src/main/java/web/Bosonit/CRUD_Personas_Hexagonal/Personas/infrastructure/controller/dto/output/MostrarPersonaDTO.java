package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output;

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
public class MostrarPersonaDTO {
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

    public Persona toPersona(MostrarPersonaDTO persona) {
        Persona devolver = new Persona();
        devolver.setId(persona.getId());
        devolver.setUser(persona.getUser());
        devolver.setPassword(persona.getPassword());
        devolver.setSurname(persona.getSurname());
        devolver.setCompany_email(persona.getCompany_email());
        devolver.setPersonal_email(persona.getCompany_email());
        devolver.setCity(persona.getCity());
        devolver.setActive(persona.getActive());
        devolver.setCreated_Date(persona.getCreated_Date());
        devolver.setImagen_url(persona.getImagen_url());
        devolver.setTermination_Date(persona.getTermination_Date());
        return devolver;
    }

    public MostrarPersonaDTO toPersonaDTO(Persona persona) {
        MostrarPersonaDTO devolver = new MostrarPersonaDTO();
        devolver.setId(persona.getId());
        devolver.setUser(persona.getUser());
        devolver.setPassword(persona.getPassword());
        devolver.setSurname(persona.getSurname());
        devolver.setCompany_email(persona.getCompany_email());
        devolver.setPersonal_email(persona.getCompany_email());
        devolver.setCity(persona.getCity());
        devolver.setActive(persona.getActive());
        devolver.setCreated_Date(persona.getCreated_Date());
        devolver.setImagen_url(persona.getImagen_url());
        devolver.setTermination_Date(persona.getTermination_Date());
        return devolver;
    }


}
