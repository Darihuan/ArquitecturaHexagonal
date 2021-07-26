package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaDTOOutput;

import java.util.List;

public interface IPersonaService {
    PersonaDTOOutput findpersonabyID(Integer id) throws Exception;

    PersonaDTOOutput findpersonabyUser(String user) throws Exception;

    List<PersonaDTOOutput> allpersonas() throws Exception;

    PersonaDTOOutput savePersona(PersonaDTOInput personaDTO) throws Exception;

    PersonaDTOOutput updatePersona(PersonaDTOInput personaDTO, Integer id) throws Exception;

    void deletePersona(Integer id) throws Exception;
}
