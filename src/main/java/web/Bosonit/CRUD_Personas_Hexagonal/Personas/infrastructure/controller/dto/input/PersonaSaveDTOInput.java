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
public class PersonaSaveDTOInput {
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

    public Persona toPersona(PersonaSaveDTOInput personaDTO){
        Persona devolver=new Persona();
        devolver.setId(personaDTO.getId());
        devolver.setUser(personaDTO.getUser());
        devolver.setPassword(personaDTO.getPassword());
        devolver.setSurname(personaDTO.getSurname());
        devolver.setCompany_email(personaDTO.getCompany_email());
        devolver.setPersonal_email(personaDTO.getCompany_email());
        devolver.setCity(personaDTO.getCity());
        devolver.setActive(personaDTO.getActive());
        devolver.setCreated_Date(personaDTO.getCreated_Date());
        devolver.setImagen_url(personaDTO.getImagen_url());
        devolver.setTermination_Date(personaDTO.getTermination_Date());
        return devolver;
    }

    public PersonaSaveDTOInput toPersonaSaveDTO(Persona persona){
        PersonaSaveDTOInput devolver=new PersonaSaveDTOInput();
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
