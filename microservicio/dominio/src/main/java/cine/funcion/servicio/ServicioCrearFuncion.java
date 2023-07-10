package cine.funcion.servicio;

import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.RepositorioFuncion;

public class ServicioCrearFuncion {
    private final RepositorioFuncion repositorioFuncion;

    public ServicioCrearFuncion(RepositorioFuncion repositorioFuncion) {
        this.repositorioFuncion = repositorioFuncion;
    }

    public Long ejecutar(Funcion funcion){
        return this.repositorioFuncion.crear(funcion);
    }
}
