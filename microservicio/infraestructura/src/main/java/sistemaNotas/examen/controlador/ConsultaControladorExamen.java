package sistemaNotas.examen.controlador;
import sistemaNotas.examen.consulta.ManejadorConsultarExamen;
import sistemaNotas.examen.consulta.ManejadorConsultarTodosExamenes;
import sistemaNotas.examen.modelo.entidad.Examen;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examen")
@Tag(name = "Controlador consulta de examen")
public class ConsultaControladorExamen {

    private final ManejadorConsultarExamen manejadorConsultarExamen;
    private final ManejadorConsultarTodosExamenes manejadorConsultarTodosExamenes;

  public ConsultaControladorExamen(ManejadorConsultarExamen manejadorConsultarExamen, ManejadorConsultarTodosExamenes manejadorConsultarTodosExamenes) {
    this.manejadorConsultarExamen = manejadorConsultarExamen;
    this.manejadorConsultarTodosExamenes = manejadorConsultarTodosExamenes;
  }


  @GetMapping
    @Operation(summary = "Obtener Examenes", description = "Metodo utilizado para consultar los examenes")
    public List<Examen> obtenerPreguntas(){
        return manejadorConsultarTodosExamenes.ejecutar();
    }

    @GetMapping("/{id}")
    public Examen obtenerPelicula(@PathVariable("id") Long id){
        return manejadorConsultarExamen.ejecutar(id);
    }


}
