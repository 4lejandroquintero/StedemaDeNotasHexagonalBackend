package sistemaNotas.pregunta.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.pregunta.comando.ComandoCrearPregunta;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;

@Component
public class FabricaCrearPregunta {

  private final ExamenRepositorio examenRepositorio;

  public FabricaCrearPregunta(ExamenRepositorio examenRepositorio) {
    this.examenRepositorio = examenRepositorio;
  }

  private Examen obtenerExamen (Long id) {
    return examenRepositorio.obtener(id);
  }

  //Esta clase es la encargada de convertir un objeto de dominio real a codigo
  public Pregunta crear(ComandoCrearPregunta comandoCrearPregunta) {
    return Pregunta.crear(obtenerExamen(comandoCrearPregunta.getExamenId()), comandoCrearPregunta.getContenido(), comandoCrearPregunta.getImagen(),
      comandoCrearPregunta.getOpcion1(), comandoCrearPregunta.getOpcion2(), comandoCrearPregunta.getOpcion3(), comandoCrearPregunta.getOpcion4(),
      comandoCrearPregunta.getRespuestaDada(), comandoCrearPregunta.getRespuesta());
  }
}
