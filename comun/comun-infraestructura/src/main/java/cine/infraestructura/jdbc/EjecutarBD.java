package cine.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}