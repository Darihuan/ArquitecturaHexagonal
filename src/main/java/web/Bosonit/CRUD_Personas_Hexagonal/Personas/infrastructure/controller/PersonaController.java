package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.application.IPersonaService;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.dto.input.PersonaDTOInput;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    IPersonaService service;

    @GetMapping("id/{id}")

    public ResponseEntity<?> findpersonabyID(@PathVariable("id") Integer id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyID(id));
        } catch (NoSuchFieldError e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe Persona con la id:" + id + " en la base de datos");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }

    }

    @GetMapping("user/{user}")

    public ResponseEntity<?> findpersonabyUser(@PathVariable("user") String user) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyUser(user));
        } catch (NoSuchFieldError e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe Persona con el user:" + user + " en la base de datos");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }

    }

    @GetMapping("")

    public ResponseEntity<?> allpersonas() throws Exception {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.allpersonas());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error servidor");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> savePersona(@RequestBody PersonaDTOInput personaDTO) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.savePersona(personaDTO));
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error servidor");

        }

    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody PersonaDTOInput personaDTO, @PathVariable("id") Integer id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updatePersona(personaDTO, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error servidor");

        }

    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Integer id) throws Exception {
        try {
            service.deletePersona(id);
            return ResponseEntity.status(HttpStatus.OK).body("persona borrada con exito");
        }catch (NoSuchElementException e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe elemento con id:"+id);
        }  catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error servidor");

        }

    }
}
