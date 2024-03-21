package sistemaNotas.categoria.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistemaNotas.examen.modelo.entidad.Examen;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearCategoria {
  private Long categoriaId;
  private String titulo;
  private String descripcion;
}
