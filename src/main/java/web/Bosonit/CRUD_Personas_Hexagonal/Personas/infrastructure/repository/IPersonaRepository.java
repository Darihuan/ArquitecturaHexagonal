package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Bosonit.CRUD_Personas_Hexagonal.Personas.domain.Persona;

import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    Optional<Persona> findByUser(String user);
}
