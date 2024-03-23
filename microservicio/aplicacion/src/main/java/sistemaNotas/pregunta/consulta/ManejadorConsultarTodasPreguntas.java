package sistemaNotas.pregunta.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

import java.util.List;

@Component
public class ManejadorConsultarTodasPreguntas {
  private final PreguntaDao preguntaDao;

  public ManejadorConsultarTodasPreguntas(PreguntaDao preguntaDao) {
    this.preguntaDao = preguntaDao;
  }

  public List<Pregunta> ejecutar(){
    return preguntaDao.obtenerTodasPreguntas();
  }
}
