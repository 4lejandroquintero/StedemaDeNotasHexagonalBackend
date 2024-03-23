package sistemaNotas.pregunta.puerto;

import sistemaNotas.pregunta.modelo.entidad.Pregunta;

public interface PreguntaRepositorio {
  Long crear(Pregunta pregunta);

  Pregunta obtener(Long id);
}

