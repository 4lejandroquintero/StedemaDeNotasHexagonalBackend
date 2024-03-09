package sistemaNotas.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}
