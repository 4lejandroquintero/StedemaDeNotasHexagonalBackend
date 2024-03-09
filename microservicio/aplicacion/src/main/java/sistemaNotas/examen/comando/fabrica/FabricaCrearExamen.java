package sistemaNotas.examen.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.examen.comando.ComandoCrearExamen;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;

@Component
public class FabricaCrearExamen {
  private final PreguntaRepositorio preguntaRepositorio;

  public FabricaCrearExamen(PreguntaRepositorio preguntaRepositorio) {
    this.preguntaRepositorio = preguntaRepositorio;
  }

  private Pregunta obtenerPregunta (Long id) { return preguntaRepositorio.obtener(id); }

  public Examen crear(ComandoCrearExamen comandoCrearExamen) {
    return Examen.crear(obtenerPregunta(comandoCrearExamen.getPreguntaId()), comandoCrearExamen.getTitulo(), comandoCrearExamen.getDescripcion(),
      comandoCrearExamen.getPuntosMaximos(), comandoCrearExamen.getNumeroDePreguntas(), comandoCrearExamen.isActivo());
  }
}
