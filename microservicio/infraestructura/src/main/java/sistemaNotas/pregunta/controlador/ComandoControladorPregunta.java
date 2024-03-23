package sistemaNotas.pregunta.controlador;

import sistemaNotas.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistemaNotas.pregunta.comando.ComandoCrearPregunta;
import sistemaNotas.pregunta.comando.manejador.ManejadorCrearPregunta;

@RestController
@RequestMapping("/pregunta")
@Tag(name = "Controlador comando pregunta")
public class ComandoControladorPregunta {
    private final ManejadorCrearPregunta manejadorCrearPregunta;

  public ComandoControladorPregunta(ManejadorCrearPregunta manejadorCrearPregunta) {
    this.manejadorCrearPregunta = manejadorCrearPregunta;
  }


  @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear pregunta", description = "Metodo para crear una pregunta")
    public ComandoRespuesta<Long> crearPregunta(@RequestBody ComandoCrearPregunta comandoCrearPregunta){
        return this.manejadorCrearPregunta.ejecutar(comandoCrearPregunta);
    }
}
