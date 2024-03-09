package sistemaNotas.pregunta.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.comando.ComandoSolicitudCrearPregunta;
import sistemaNotas.pregunta.entidad.Pregunta;

@Component
public class GeneradorPregunta {
  //Esta clase es la encargada de convertir un objeto de dominio real a codigo
  public Pregunta crear(ComandoSolicitudCrearPregunta comandoSolicitudCrearPregunta) {
    return new Pregunta(comandoSolicitudCrearPregunta.getPreguntaId(), comandoSolicitudCrearPregunta.getContenido(), comandoSolicitudCrearPregunta.getImagen(),
      comandoSolicitudCrearPregunta.getOpcion1(), comandoSolicitudCrearPregunta.getOpcion2(), comandoSolicitudCrearPregunta.getOpcion3(), comandoSolicitudCrearPregunta.getOpcion4(),
      comandoSolicitudCrearPregunta.getRespuestaDada(), comandoSolicitudCrearPregunta.getRespuesta());
  }
}
