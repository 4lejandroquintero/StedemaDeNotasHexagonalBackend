package sistemaNotas.examen.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.dao.ExamenDao;

import java.util.List;

@Component
public class ManejadorConsultarTodosExamenes {
  private final ExamenDao examenDao;

  public ManejadorConsultarTodosExamenes(ExamenDao examenDao) {
    this.examenDao = examenDao;
  }

  public List<Examen> ejecutar() { return examenDao.obtenerTodosExamenes(); }
}
