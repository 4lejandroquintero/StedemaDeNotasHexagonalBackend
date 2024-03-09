package sistemaNotas.pregunta.puerto;

import sistemaNotas.pregunta.entidad.Pregunta;

public interface PreguntaRepositorio {
  Long crear(Pregunta pregunta);

  Pregunta obtener(Long id);
}

