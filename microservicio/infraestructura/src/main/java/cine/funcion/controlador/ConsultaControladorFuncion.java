package cine.funcion.controlador;
import cine.funcion.consulta.ManejadorConsultarFuncion;
import cine.funcion.consulta.ManejadorConsultarTodasFunciones;
import cine.funcion.modelo.entidad.Funcion;
import cine.pelicula.entidad.dto.PeliculaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcion")
@Tag(name = "Controlador consulta de funcion")
public class ConsultaControladorFuncion {

    private final ManejadorConsultarFuncion manejadorConsultarFuncion;
    private final ManejadorConsultarTodasFunciones manejadorConsultarTodasFunciones;
    public ConsultaControladorFuncion(ManejadorConsultarFuncion manejadorConsultarFuncion, ManejadorConsultarTodasFunciones manejadorConsultarTodasFunciones) {
        this.manejadorConsultarFuncion = manejadorConsultarFuncion;
        this.manejadorConsultarTodasFunciones = manejadorConsultarTodasFunciones;
    }
    @GetMapping
    @Operation(summary = "Obtener Funciones", description = "Metodo utilizado para consultar las funciones")
    public List<Funcion> obtenerPeliculas(){
        return manejadorConsultarTodasFunciones.ejecutar();
    }

    @GetMapping("/{id}")
    public Funcion obtenerPelicula(@PathVariable("id") Long id){
        return manejadorConsultarFuncion.ejecutar(id);
    }


}
