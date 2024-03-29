package sistemaNotas.categoria.controlador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistemaNotas.categoria.consulta.ManejadorConsultaCategoria;
import sistemaNotas.categoria.consulta.ManejadorConsultarCategoriaPorExamen;
import sistemaNotas.categoria.entidad.Categoria;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@Tag(name = "Controlador consulta de categorias")
public class ConsultaControladorCategoria {

    private final ManejadorConsultaCategoria manejadorConsultaCategoria;

  public ConsultaControladorCategoria(ManejadorConsultaCategoria manejadorConsultaCategoria) {
    this.manejadorConsultaCategoria = manejadorConsultaCategoria;
  }




    @GetMapping("/{id}")
    public Categoria obtener(@PathVariable("id") Long id){
        return manejadorConsultaCategoria.ejecutar(id);
    }


}
