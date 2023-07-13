package cine.pelicula.consulta;

import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.dao.DaoPelicula;
import org.springframework.stereotype.Component;


@Component
public class ManejadorObtenerPelicula {
    private final DaoPelicula daoPelicula;

    public ManejadorObtenerPelicula(DaoPelicula daoPelicula) {
        this.daoPelicula = daoPelicula;
    }

    public Pelicula ejecutar(Long id){
        return daoPelicula.obtenerPeliculaPorID(id);
    }


}
