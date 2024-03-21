package sistemaNotas.categoria.servicio;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.CategoriaRepositorio;

public class ServicioCrearCategoria {
  private final CategoriaRepositorio categoriaRepositorio;


  public ServicioCrearCategoria(CategoriaRepositorio categoriaRepositorio) {
    this.categoriaRepositorio = categoriaRepositorio;
  }

  public Long ejecutar(Categoria categoria) {
    return this.categoriaRepositorio.crearCategoria(categoria);
  }
}
