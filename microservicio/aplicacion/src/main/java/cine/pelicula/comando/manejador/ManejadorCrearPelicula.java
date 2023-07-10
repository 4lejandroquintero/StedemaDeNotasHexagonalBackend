package cine.pelicula.comando.manejador;

import cine.ComandoRespuesta;
import cine.manejador.ManejadorComandoRespuesta;
import cine.pelicula.comando.ComandoSolicitudCrearPelicula;
import cine.pelicula.comando.fabrica.GeneradorPelicula;
import cine.pelicula.servicio.ServicioCrearPelicula;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPelicula implements ManejadorComandoRespuesta<ComandoSolicitudCrearPelicula, ComandoRespuesta<Long>> {
    private final GeneradorPelicula generadorPelicula;
    private final ServicioCrearPelicula servicioCrearPelicula;

    public ManejadorCrearPelicula(GeneradorPelicula generadorPelicula, ServicioCrearPelicula servicioCrearPelicula) {
        this.generadorPelicula = generadorPelicula;
        this.servicioCrearPelicula = servicioCrearPelicula;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearPelicula comandoSolicitudCrearPelicula) {
        return new ComandoRespuesta<>(servicioCrearPelicula.ejecutar(generadorPelicula.crear(comandoSolicitudCrearPelicula)));
    }
}
