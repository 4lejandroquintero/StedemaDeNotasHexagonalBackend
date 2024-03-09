package sistemaNotas.categoria.puerto.dao;

import sistemaNotas.categoria.entidad.Categoria;

import java.util.List;

public interface CategoriaDao {
  List<Categoria> obtenerCategoriaDeExamen(Long id);
  Categoria obtenerCategoria(Long id);
}
