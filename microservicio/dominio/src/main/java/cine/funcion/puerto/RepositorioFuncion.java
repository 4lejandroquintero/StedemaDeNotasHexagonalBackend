package cine.funcion.puerto;

import cine.funcion.modelo.entidad.Funcion;

public interface RepositorioFuncion {
    Long crear(Funcion funcion);

    Funcion obtener(Long id);

    boolean existe (String nombre);

    void eliminar(Long id);
    void actualizar(Funcion funcion);

    boolean existePorId(Long id);
}
