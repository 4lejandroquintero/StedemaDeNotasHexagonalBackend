package cine.funcion.puerto.dao;

import cine.funcion.modelo.entidad.Funcion;


import java.util.List;

public interface DaoFuncion {
    List<Funcion> obtenerTodasFunciones();
    Funcion obtenerFuncion(Long id);
}
