package cine.funcion.puerto;

import cine.funcion.modelo.entidad.Funcion;

public interface RepositorioFuncion {
    Long crear(Funcion funcion);

    Funcion obtener(Long id);
}
