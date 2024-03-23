package sistemaNotas.pregunta.controlador;

import sistemaNotas.pregunta.consulta.ManejadorConsultarPregunta;
import sistemaNotas.pregunta.consulta.ManejadorConsultarTodasPreguntas;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
@Tag(name = "Controlador consulta pregunta")
public class ConsultaControladorPregunta {
    private final ManejadorConsultarPregunta manejadorConsultarPregunta;
    private final ManejadorConsultarTodasPreguntas manejadorConsultarTodasPreguntas;

  public ConsultaControladorPregunta(ManejadorConsultarPregunta manejadorConsultarPregunta, ManejadorConsultarTodasPreguntas manejadorConsultarTodasPreguntas) {
    this.manejadorConsultarPregunta = manejadorConsultarPregunta;
    this.manejadorConsultarTodasPreguntas = manejadorConsultarTodasPreguntas;
  }


    @GetMapping
    @Operation(summary = "Obtener Preguntas", description = "Metodo utilizado para consultar las preguntas")
    public List<Pregunta> obtenerExamenes(){
        return manejadorConsultarTodasPreguntas.ejecutar();
    }

    @GetMapping("/{id}")
    public Pregunta obtenerPregunta(@PathVariable("id") Long id){
        return manejadorConsultarPregunta.ejecutar(id);
    }


}
