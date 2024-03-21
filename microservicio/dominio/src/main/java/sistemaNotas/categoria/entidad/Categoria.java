package sistemaNotas.categoria.entidad;

import sistemaNotas.dominio.ValidadorArgumento;
import sistemaNotas.examen.modelo.entidad.Examen;

import java.util.LinkedHashSet;
import java.util.Set;

public class Categoria {
  private Long categoriaId;
  private final String titulo;
  private final String descripcion;
  private  Set<Examen> examen = new LinkedHashSet<>();

  public Categoria(Long categoriaId, String titulo, String descripcion) {
    this.categoriaId = categoriaId;
    this.titulo = titulo;
    this.descripcion = descripcion;
  }

  public Categoria(String titulo, String descripcion) {
    this.titulo = titulo;
    this.descripcion = descripcion;
  }

  public static Categoria reconstruir(Long categoriaId, String titulo, String descripcion) {
    ValidadorArgumento.validarObligatorio(categoriaId, "El id de la categoria es obligatorio");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo de la categoría es obligatorio");
    return new Categoria(categoriaId, titulo, descripcion);
  }

  public static Categoria crearCategoria(String titulo, String descripcion) {
    ValidadorArgumento.validarObligatorio(titulo, "El titulo de la categoría es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripción de la categpria es obligatoria");
    return new Categoria(titulo, descripcion);
  }

  public Long getCategoriaId() {
    return categoriaId;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Set<Examen> getExamen() {
    return examen;
  }


}
