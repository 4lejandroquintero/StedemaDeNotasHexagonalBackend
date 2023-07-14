package cine.pelicula.servicio;

import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;

public class ServicioCrearPelicula {
    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }
    public Long ejecutar(Pelicula pelicula){
        return repositorioPelicula.crear(pelicula);
    }
}
