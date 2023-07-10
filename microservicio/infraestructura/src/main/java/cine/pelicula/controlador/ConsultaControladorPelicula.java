package cine.pelicula.controlador;

import cine.pelicula.consulta.ManejadorObtenerPelicula;
import cine.pelicula.consulta.ManejadorObtenerPeliculas;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.entidad.dto.PeliculaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pelicula")
@Tag(name = "Controlador consulta pelicula")
public class ConsultaControladorPelicula {
    private final ManejadorObtenerPelicula manejadorObtenerPelicula;
    private final ManejadorObtenerPeliculas manejadorObtenerPeliculas;

    public ConsultaControladorPelicula(ManejadorObtenerPelicula manejadorObtenerPelicula, ManejadorObtenerPeliculas manejadorObtenerPeliculas) {

        this.manejadorObtenerPelicula = manejadorObtenerPelicula;
        this.manejadorObtenerPeliculas = manejadorObtenerPeliculas;
    }

    @GetMapping
    @Operation(summary = "Anular", description = "Metodo utilizado para consultar los datos de los clientes")
    public List<PeliculaDTO> obtenerPeliculas(){
        return manejadorObtenerPeliculas.ejecutar();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPelicula(@PathVariable("id") Long id){
        return manejadorObtenerPelicula.ejecutar(id);
    }
}
