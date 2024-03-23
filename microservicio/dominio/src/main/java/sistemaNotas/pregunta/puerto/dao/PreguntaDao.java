package sistemaNotas.pregunta.puerto.dao;

import sistemaNotas.pregunta.modelo.entidad.Pregunta;

import java.util.List;

public interface PreguntaDao {
  List<Pregunta> obtenerTodasPreguntas();
  Pregunta obtenerPregunta(Long id);
}
