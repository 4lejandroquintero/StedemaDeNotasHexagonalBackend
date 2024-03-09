package sistemaNotas.pregunta.servicio;

import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;

public class ServicioCrearPregunta {
  private final PreguntaRepositorio preguntaRepositorio;

  public ServicioCrearPregunta(PreguntaRepositorio preguntaRepositorio) {
    this.preguntaRepositorio = preguntaRepositorio;
  }
  public Long ejecutar(Pregunta pregunta){
    return preguntaRepositorio.crear(pregunta);
  }
}
