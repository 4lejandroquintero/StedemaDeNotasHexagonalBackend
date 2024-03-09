package sistemaNotas.categoria.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.dao.CategoriaDao;

@Component
public class ManejadorConsultaCategoria {
  private final CategoriaDao categoriaDao;

  public ManejadorConsultaCategoria(CategoriaDao categoriaDao) {
    this.categoriaDao = categoriaDao;
  }

  public Categoria ejecutar(Long id) { return categoriaDao.obtenerCategoria(id); }
}
