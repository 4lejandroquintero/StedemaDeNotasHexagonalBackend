package cine.pelicula.servicio;

import cine.dominio.excepcion.ExcepcionDuplicidad;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;

public class ServicioCrearPelicula {
    private static final String PELICULA_YA_EXISTE_EN_EL_SISTEMA = "La pelicula existe en el sistema";
    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }
    public Long ejecutar(Pelicula pelicula){
        return repositorioPelicula.crear(pelicula);
    }
}
