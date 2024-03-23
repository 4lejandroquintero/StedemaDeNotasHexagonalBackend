package sistemaNotas.examen.modelo.entidad;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.dominio.ValidadorArgumento;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;

import java.util.HashSet;
import java.util.Set;

public class Examen {
  private Long examenId;
  private Categoria categoria;
  private String titulo;
  private String descripcion;
  private String puntosMaximos;
  private String numeroDePreguntas;
  private boolean activo = false;

  private Set<Pregunta> preguntas = new HashSet<>();

  public Examen(Long examenId, Categoria categoria, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo) {
    this.examenId = examenId;
    this.categoria = categoria;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.puntosMaximos = puntosMaximos;
    this.numeroDePreguntas = numeroDePreguntas;
    this.activo = activo;
  }

  public Examen(Categoria categoria, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo) {
    this.categoria = categoria;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.puntosMaximos = puntosMaximos;
    this.numeroDePreguntas = numeroDePreguntas;
    this.activo = activo;
  }

  public static Examen reconstruir(Long examenId, Categoria categoria, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo){
    ValidadorArgumento.validarObligatorio(examenId, "El id del Examen es obligatorio");
    ValidadorArgumento.validarObligatorio(categoria, "La categoria del examene s obligatoria");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo del examen es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripcion del examen es obligatoria");
    ValidadorArgumento.validarObligatorio(puntosMaximos, "Los puntos máximos del examen son obligatorios");
    ValidadorArgumento.validarObligatorio(numeroDePreguntas, "El numero de pregunta es obligatorio");
    ValidadorArgumento.validarObligatorio(activo, "El estado del examen es obligatorio");
    return new Examen(examenId,categoria,titulo,descripcion,puntosMaximos,numeroDePreguntas,activo);
  }

  public static Examen crear(Categoria categoria, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo){
    ValidadorArgumento.validarObligatorio(categoria, "La categoria del examene s obligatoria");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo del examen es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripcion del examen es obligatoria");
    ValidadorArgumento.validarObligatorio(puntosMaximos, "Los puntos máximos del examen son obligatorios");
    ValidadorArgumento.validarObligatorio(numeroDePreguntas, "El numero de pregunta es obligatorio");
    ValidadorArgumento.validarObligatorio(activo, "El estado del examen es obligatorio");
    return new Examen(categoria,titulo,descripcion,puntosMaximos,numeroDePreguntas,activo);
  }

  public Long getExamenId() {
    return examenId;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getPuntosMaximos() {
    return puntosMaximos;
  }

  public String getNumeroDePreguntas() {
    return numeroDePreguntas;
  }

  public boolean isActivo() {
    return activo;
  }


  public Set<Pregunta> getPreguntas() {
    return preguntas;
  }

}
