package sistemaNotas.examen.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.dao.ExamenDao;

@Component
public class ManejadorConsultarExamen {
  private final ExamenDao examenDao;

  public ManejadorConsultarExamen(ExamenDao examenDao) {
    this.examenDao = examenDao;
  }

  public Examen ejecutar(Long id) { return examenDao.obtenerExamen(id); }
}
