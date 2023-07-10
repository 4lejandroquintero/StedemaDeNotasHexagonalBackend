package cine.pelicula.controlador;

import cine.ComandoRespuesta;
import cine.pelicula.comando.ComandoSolicitudCrearPelicula;
import cine.pelicula.comando.manejador.ManejadorCrearPelicula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelicula")
@Tag(name = "Controlador comando pelicula")
public class ComandoControladorPelicula {
    private final ManejadorCrearPelicula manejadorCrearPelicula;

    public ComandoControladorPelicula(ManejadorCrearPelicula manejadorCrearPelicula) {
        this.manejadorCrearPelicula = manejadorCrearPelicula;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear pelicula", description = "Metodo para crear una pelicula")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearPelicula comandoSolicitudCrearPelicula){
        return this.manejadorCrearPelicula.ejecutar(comandoSolicitudCrearPelicula);
    }
}
