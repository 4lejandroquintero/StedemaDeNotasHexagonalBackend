package sistemaNotas.categoria.controlador;

import sistemaNotas.ComandoRespuesta;
import sistemaNotas.categoria.comando.ComandoSolicitudCrearCategoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistemaNotas.categoria.comando.manejador.ManejadorCrearCategoria;

@RestController
@RequestMapping("/categoria")
@Tag(name = "Controlador comando de categorias")
public class ComandoControladorCategoria {
    private final ManejadorCrearCategoria manejadorCrearCategoria;

    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria) {
        this.manejadorCrearCategoria = manejadorCrearCategoria;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear Categoria", description = "Metodo utilizado para crear una categoria")
    public ComandoRespuesta<Long> guardarCategoria(@RequestBody ComandoSolicitudCrearCategoria comandoSolicitudCrearCategoria){
        return this.manejadorCrearCategoria.ejecutar(comandoSolicitudCrearCategoria);
    }

}
