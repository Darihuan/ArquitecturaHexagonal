package web.Bosonit.CRUD_Personas_Hexagonal.Personas.infrastructure.controller.Errores;

public class UnprocesableException extends RuntimeException {
    public UnprocesableException(String mensaje) {
        super(mensaje);
    }
}
