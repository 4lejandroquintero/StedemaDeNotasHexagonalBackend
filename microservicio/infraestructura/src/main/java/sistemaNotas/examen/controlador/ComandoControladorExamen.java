package sistemaNotas.examen.controlador;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.examen.comando.ComandoCrearExamen;
import sistemaNotas.examen.comando.manejador.ManejadorCrearExamen;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examen")
@Tag(name = "Controlador comando de examen")
public class ComandoControladorExamen {
    private final ManejadorCrearExamen manejadorCrearExamen;

  public ComandoControladorExamen(ManejadorCrearExamen manejadorCrearExamen) {
    this.manejadorCrearExamen = manejadorCrearExamen;
  }

  @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear Examen con la Pregunta", description = "Metodo utilizado para crear un examen")
    public ComandoRespuesta<Long> crearExamen(@RequestBody ComandoCrearExamen comandoCrearExamen){
        return this.manejadorCrearExamen.ejecutar(comandoCrearExamen);
    }

}
