package sistemaNotas.categoria.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.dao.CategoriaDao;

import java.util.List;

@Component
public class ManejadorConsultarCategoriaPorExamen {
  private final CategoriaDao categoriaDao;

  public ManejadorConsultarCategoriaPorExamen(CategoriaDao categoriaDao) {
    this.categoriaDao = categoriaDao;
  }

  public Categoria ejecutar(Long id) { return categoriaDao.obtenerCategoria(id); }
}
