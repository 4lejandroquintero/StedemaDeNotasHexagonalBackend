package sistemaNotas.pregunta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearPregunta {
  private Long preguntaId;
  private String contenido;
  private String imagen;
  private String opcion1;
  private String opcion2;
  private String opcion3;
  private String opcion4;
  private String respuestaDada;
  private String respuesta;
}
