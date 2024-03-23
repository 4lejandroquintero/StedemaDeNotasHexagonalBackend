package sistemaNotas.pregunta.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

@Component
public class ManejadorConsultarPregunta {
  private final PreguntaDao preguntaDao;

  public ManejadorConsultarPregunta(PreguntaDao preguntaDao) {
    this.preguntaDao = preguntaDao;
  }

  public Pregunta ejecutar(Long id){
    return preguntaDao.obtenerPregunta(id);
  }
}
