package sistemaNotas.examen.puerto.dao;

import sistemaNotas.examen.modelo.entidad.Examen;

import java.util.List;

public interface ExamenDao {
  List<Examen> obtenerTodosExamenes();
  Examen obtenerExamen(Long id);
}
