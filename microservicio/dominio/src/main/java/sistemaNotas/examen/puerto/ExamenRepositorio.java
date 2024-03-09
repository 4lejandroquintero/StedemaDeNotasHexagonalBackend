package sistemaNotas.examen.puerto;

import sistemaNotas.examen.modelo.entidad.Examen;

public interface ExamenRepositorio {
  Long crear(Examen examen);

  Examen obtener(Long id);
}
