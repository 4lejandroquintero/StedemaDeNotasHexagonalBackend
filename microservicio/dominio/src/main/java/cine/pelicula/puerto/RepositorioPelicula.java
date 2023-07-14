package cine.pelicula.puerto;

import cine.pelicula.entidad.Pelicula;

public interface RepositorioPelicula {
    Long crear(Pelicula pelicula);

    Pelicula obtener(Long id);
}
