package cine.pelicula.comando.fabrica;

import cine.pelicula.comando.ComandoSolicitudCrearPelicula;
import cine.pelicula.entidad.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class GeneradorPelicula {
    //Esta clase es la encargada de convertir un objeto de dominio real a codigo
    public Pelicula crear(ComandoSolicitudCrearPelicula comandoSolicitudCrearPelicula){
        return new Pelicula(comandoSolicitudCrearPelicula.getIdPelicula(), comandoSolicitudCrearPelicula.getNombrePelicula(), comandoSolicitudCrearPelicula.getSinopsisPelicula(),
                comandoSolicitudCrearPelicula.getImagenPortada(), comandoSolicitudCrearPelicula.getCategoriaEdadPelicula());
    }
}
