package cine.funcion.controlador;
import cine.ComandoRespuesta;
import cine.funcion.comando.ComandoCrearFuncion;
import cine.funcion.comando.manejador.ManejadorCrearFuncion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcion")
@Tag(name = "Controlador comando de funcion")
public class ComandoControladorFuncion {
    private final ManejadorCrearFuncion manejadorCrearFuncion;

    public ComandoControladorFuncion(ManejadorCrearFuncion manejadorCrearFuncion) {
        this.manejadorCrearFuncion = manejadorCrearFuncion;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear Funcion de Pelicula", description = "Metodo utilizado para crear una funcion")
    public ComandoRespuesta<Long> crearFuncion(@RequestBody ComandoCrearFuncion comandoCrearFuncion){
        return this.manejadorCrearFuncion.ejecutar(comandoCrearFuncion);
    }

}
