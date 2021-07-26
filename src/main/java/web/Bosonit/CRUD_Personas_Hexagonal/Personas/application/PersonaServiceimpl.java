package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation.Ivalidation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.domain.Persona;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaSaveDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaUpdateDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.MostrarPersonaDTO;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaSaveDTOOutput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaUpdateDTOOutput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.repository.IPersonaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceimpl implements IPersonaService {
    @Autowired
    IPersonaRepository repositorio;
    @Autowired
    Ivalidation validador;

    @Override
    @Transactional
    public MostrarPersonaDTO findpersonabyID(Integer id) throws Exception {
        Persona persona = repositorio.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con id:" + id));
        MostrarPersonaDTO devolverDTO = new MostrarPersonaDTO();
        devolverDTO = devolverDTO.toPersonaDTO(persona);
        return devolverDTO;

    }

    @Override
    @Transactional
    public MostrarPersonaDTO findpersonabyUser(String user) throws Exception {
        Persona persona = repositorio.findByUser(user).orElseThrow(() -> new NoSuchElementException("no existe usuario con user:" + user));
        MostrarPersonaDTO devolverDTO = new MostrarPersonaDTO();
        devolverDTO = devolverDTO.toPersonaDTO(persona);
        return devolverDTO;

    }

    @Override
    @Transactional
    public List<MostrarPersonaDTO> allpersonas() throws Exception {

        List<Persona> personas = repositorio.findAll();
        List<MostrarPersonaDTO> personasDTO = new ArrayList();
        MostrarPersonaDTO guardar = new MostrarPersonaDTO();
        for (Persona elemento : personas) {
            personasDTO.add(guardar.toPersonaDTO(elemento));
        }
        return personasDTO;
    }


    @Override
    @Transactional
    public PersonaSaveDTOOutput savePersona(PersonaSaveDTOInput personaDTO) throws Exception {
        Persona persona = personaDTO.toPersona(personaDTO);

        validador.validarPersona(persona);

        persona = repositorio.save(persona);
        PersonaSaveDTOOutput personaDTOOutput = new PersonaSaveDTOOutput();
        personaDTOOutput = personaDTOOutput.toPersonaSaveDTO(persona);
        return personaDTOOutput;

    }

    @Override
    @Transactional
    public PersonaUpdateDTOOutput updatePersona(PersonaUpdateDTOInput personaDTO, Integer id) throws Exception {
        Persona persona = personaDTO.toPersona(personaDTO);
        validador.validarPersona(persona);

        Persona comprobarExistePersona = repositorio.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con id:" + id));
        if (comprobarExistePersona.getId() == persona.getId()) {
            persona = repositorio.save(persona);
            PersonaUpdateDTOOutput personaDTOOutput = new PersonaUpdateDTOOutput();
            personaDTOOutput = personaDTOOutput.toPersonaUpdateDTO(persona);
            return personaDTOOutput;

        }
        throw new Exception("Numero de id de la personaDTO no coincide con el id:" + id + "en el objeto que se quiere actualizar");


    }

    @Override
    @Transactional
    public void deletePersona(Integer id) throws Exception {
        Persona borrado = repositorio.getById(id);
        if (borrado != null) {
            repositorio.deleteById(id);
        }
        throw new NoSuchElementException("no existe persona con id:"+id+"en la base de datos");

    }
}
