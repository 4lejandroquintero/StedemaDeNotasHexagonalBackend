package sistemaNotas.examen.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCrearExamen {
  private Long categoriaId;
  private String titulo;
  private String descripcion;
  private String puntosMaximos;
  private String numeroDePreguntas;
  private boolean activo = false;
  private String categoria;
}
