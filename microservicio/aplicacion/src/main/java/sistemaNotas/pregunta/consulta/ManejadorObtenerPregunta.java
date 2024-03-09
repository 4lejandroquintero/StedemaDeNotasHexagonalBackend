package sistemaNotas.pregunta.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

@Component
public class ManejadorObtenerPregunta {
  private final PreguntaDao preguntaDao;

  public ManejadorObtenerPregunta(PreguntaDao preguntaDao) {
    this.preguntaDao = preguntaDao;
  }

  public Pregunta ejecutar(Long id){
    return preguntaDao.obtenerPreguntaPorID(id);
  }
}
