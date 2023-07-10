package cine.pelicula.puerto.dao;


import cine.pelicula.entidad.Pelicula;
import cine.pelicula.entidad.dto.PeliculaDTO;

import java.util.List;


public interface DaoPelicula {
    List<PeliculaDTO> obtenerTodasPeliculas();
    Pelicula obtenerPeliculaPorID(Long id);
}
