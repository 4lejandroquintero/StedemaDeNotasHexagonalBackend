package sistemaNotas.pregunta.controlador;

import sistemaNotas.pregunta.consulta.ManejadorObtenerPregunta;
import sistemaNotas.pregunta.consulta.ManejadorObtenerPreguntas;
import sistemaNotas.pregunta.entidad.Pregunta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistemaNotas.pregunta.entidad.dto.PreguntaDTO;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
@Tag(name = "Controlador consulta pregunta")
public class ConsultaControladorPregunta {
    private final ManejadorObtenerPregunta manejadorObtenerPregunta;
    private final ManejadorObtenerPreguntas manejadorObtenerPreguntas;

  public ConsultaControladorPregunta(ManejadorObtenerPregunta manejadorObtenerPregunta, ManejadorObtenerPreguntas manejadorObtenerPreguntas) {
    this.manejadorObtenerPregunta = manejadorObtenerPregunta;
    this.manejadorObtenerPreguntas = manejadorObtenerPreguntas;
  }


  @GetMapping
    @Operation(summary = "Anular", description = "Metodo utilizado para consultar los datos de los usuarios")
    public List<PreguntaDTO> obtenerPreguntas(){
        return manejadorObtenerPreguntas.ejecutar();
    }

    @GetMapping("/{id}")
    public Pregunta obtenerPregunta(@PathVariable("id") Long id){
        return manejadorObtenerPregunta.ejecutar(id);
    }
}
