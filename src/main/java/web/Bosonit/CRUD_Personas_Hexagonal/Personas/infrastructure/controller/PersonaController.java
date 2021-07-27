package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.IPersonaService;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/personas")

public class PersonaController {
    @Autowired
    IPersonaService service;

    @GetMapping("id/{id}")

    public ResponseEntity<?> findpersonabyID(@PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyID(id));

    }

    @GetMapping("user/{user}")

    public ResponseEntity<?> findpersonabyUser(@PathVariable("user") String user) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyUser(user));


    }

    @GetMapping("")

    public ResponseEntity<?> allpersonas() throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.allpersonas());

    }

    @PostMapping("")
    public ResponseEntity<?> savePersona(@RequestBody @Valid PersonaDTOInput personaDTO) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePersona(personaDTO));

    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody @Valid PersonaDTOInput personaDTO, @PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.updatePersona(personaDTO, id));

    }



    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Integer id) throws Exception {

        service.deletePersona(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("persona borrada con exito");


    }
}
