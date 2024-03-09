package sistemaNotas.pregunta.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.entidad.dto.PreguntaDTO;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

import java.util.List;

@Component
public class ManejadorObtenerPreguntas {
  private final PreguntaDao preguntaDao;

  public ManejadorObtenerPreguntas(PreguntaDao preguntaDao) {
    this.preguntaDao = preguntaDao;
  }

  public List<PreguntaDTO> ejecutar(){
    return preguntaDao.obtenerTodasPreguntas();
  }
}
