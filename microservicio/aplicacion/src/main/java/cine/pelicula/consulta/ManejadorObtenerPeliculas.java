package cine.pelicula.consulta;

import cine.pelicula.entidad.dto.PeliculaDTO;
import cine.pelicula.puerto.dao.DaoPelicula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerPeliculas {
    private final DaoPelicula daoPelicula;

    public ManejadorObtenerPeliculas(DaoPelicula daoPelicula) {
        this.daoPelicula = daoPelicula;
    }

    public List<PeliculaDTO> ejecutar(){
        return daoPelicula.obtenerTodasPeliculas();
    }

}
