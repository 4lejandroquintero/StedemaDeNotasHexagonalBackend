package sistemaNotas.pregunta.entidad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sistemaNotas.examen.modelo.entidad.Examen;

@AllArgsConstructor
@Getter
public class PreguntaDTO {
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
