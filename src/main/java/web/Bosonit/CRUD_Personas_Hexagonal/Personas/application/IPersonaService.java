package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application;

import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaSaveDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaUpdateDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.MostrarPersonaDTO;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaSaveDTOOutput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaUpdateDTOOutput;

import java.util.List;

public interface IPersonaService {
    MostrarPersonaDTO findpersonabyID(Integer id) throws Exception;

    MostrarPersonaDTO findpersonabyUser(String user) throws Exception;

    List<MostrarPersonaDTO> allpersonas() throws Exception;

    PersonaSaveDTOOutput savePersona(PersonaSaveDTOInput personaDTO) throws Exception;

    PersonaUpdateDTOOutput updatePersona(PersonaUpdateDTOInput personaDTO, Integer id) throws Exception;

    void deletePersona(Integer id) throws Exception;
}
