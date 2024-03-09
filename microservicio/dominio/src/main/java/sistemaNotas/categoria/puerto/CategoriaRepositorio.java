package sistemaNotas.categoria.puerto;

import sistemaNotas.categoria.entidad.Categoria;

public interface CategoriaRepositorio {
  Long crear(Categoria categoria);
  Categoria obtener(Long id);
  boolean existe (Long id);
}
