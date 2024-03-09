package sistemaNotas.pregunta.puerto.dao;

import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.entidad.dto.PreguntaDTO;

import java.util.List;

public interface PreguntaDao {
  List<PreguntaDTO> obtenerTodasPreguntas();
  Pregunta obtenerPreguntaPorID(Long id);
}
