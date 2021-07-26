package web.Bosonit.CRUD_Personas_Hexagonal.Personas.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.validation.Ivalidation;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.domain.Persona;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.output.PersonaDTOOutput;
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
    public PersonaDTOOutput findpersonabyID(Integer id) throws Exception {
        Persona persona = repositorio.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con id:" + id));

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public PersonaDTOOutput findpersonabyUser(String user) throws Exception {
        Persona persona = repositorio.findByUser(user).orElseThrow(() -> new NoSuchElementException("no existe usuario con user:" + user));

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public List<PersonaDTOOutput> allpersonas() throws Exception {

        List<Persona> personas = repositorio.findAll();
        List<PersonaDTOOutput> personasDTO = new ArrayList();
        personas.forEach(persona -> personasDTO.add(new PersonaDTOOutput(persona)));
        return personasDTO;
    }


    @Override
    @Transactional
    public PersonaDTOOutput savePersona(PersonaDTOInput personaDTO) throws Exception {
        validador.validarPersona(personaDTO);

        Persona persona = new Persona(personaDTO);

        repositorio.save(persona);

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public PersonaDTOOutput updatePersona(PersonaDTOInput personaDTO, Integer id) throws Exception {
        validador.validarPersona(personaDTO);

        Persona persona = new Persona(personaDTO);

        Persona comprobarExistePersona = repositorio.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con id:" + id));

        repositorio.save(persona);

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public void deletePersona(Integer id) throws Exception {
        Persona borrado = repositorio.findById(id).orElseThrow(()->new NoSuchElementException("no existe elemento con id:"+id+" para ser borrado"));
            repositorio.deleteById(id);
    }
}
