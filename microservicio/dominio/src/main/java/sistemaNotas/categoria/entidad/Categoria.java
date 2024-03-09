package sistemaNotas.categoria.entidad;

import sistemaNotas.dominio.ValidadorArgumento;
import sistemaNotas.examen.modelo.entidad.Examen;

public class Categoria {
  private Long categoriaId;
  private final String titulo;
  private final String descripcion;
  private final Examen examen;

  public Categoria(Long categoriaId, String titulo, String descripcion, Examen examen) {
    this.categoriaId = categoriaId;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.examen = examen;
  }

  public Categoria(String titulo, String descripcion, Examen examen) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.examen = examen;
  }

  public static Categoria reconstruir(Long categoriaId, String titulo, String descripcion, Examen examen) {
    ValidadorArgumento.validarObligatorio(categoriaId, "El id de la categoria es obligatorio");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo de la categoría es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripción de la categpria es obligatoria");
    ValidadorArgumento.validarObligatorio(examen, "Es necesario ingresar el examen, es requerido");
    return new Categoria(categoriaId, titulo, descripcion, examen);
  }

  public static Categoria crear(String titulo, String descripcion, Examen examen) {
    ValidadorArgumento.validarObligatorio(titulo, "El titulo de la categoría es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripción de la categpria es obligatoria");
    ValidadorArgumento.validarObligatorio(examen, "Es necesario ingresar el examen, es requerido");
    return new Categoria(titulo, descripcion, examen);
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

  public Examen getExamen() {
    return examen;
  }
}
