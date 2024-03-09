package sistemaNotas.examen.modelo.entidad;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.dominio.ValidadorArgumento;
import sistemaNotas.pregunta.entidad.Pregunta;

public class Examen {
  private Long examenId;
  private Pregunta pregunta;
  private String titulo;
  private String descripcion;
  private String puntosMaximos;
  private String numeroDePreguntas;
  private boolean activo = false;

  public Examen(Long examenId, Pregunta pregunta, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo) {
    this.examenId = examenId;
    this.pregunta = pregunta;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.puntosMaximos = puntosMaximos;
    this.numeroDePreguntas = numeroDePreguntas;
    this.activo = activo;
  }

  public Examen(Pregunta pregunta, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo) {
    this.pregunta = pregunta;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.puntosMaximos = puntosMaximos;
    this.numeroDePreguntas = numeroDePreguntas;
    this.activo = activo;
  }

  public static Examen reconstruir(Long examenId,Pregunta pregunta, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo){
    ValidadorArgumento.validarObligatorio(examenId, "El id del Examen es obligatorio");
    ValidadorArgumento.validarObligatorio(pregunta, "Es necesario ingresar las preguntas");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo del examen es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripcion del examen es obligatoria");
    ValidadorArgumento.validarObligatorio(puntosMaximos, "Los puntos máximos del examen son obligatorios");
    ValidadorArgumento.validarObligatorio(numeroDePreguntas, "El numero de pregunta es obligatorio");
    ValidadorArgumento.validarObligatorio(activo, "El estado del examen es obligatorio");
    return new Examen(examenId,pregunta,titulo,descripcion,puntosMaximos,numeroDePreguntas,activo);
  }

  public static Examen crear(Pregunta pregunta, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas, boolean activo){
    ValidadorArgumento.validarObligatorio(pregunta, "Es necesario ingresar las preguntas");
    ValidadorArgumento.validarObligatorio(titulo, "El titulo del examen es obligatorio");
    ValidadorArgumento.validarObligatorio(descripcion, "La descripcion del examen es obligatoria");
    ValidadorArgumento.validarObligatorio(puntosMaximos, "Los puntos máximos del examen son obligatorios");
    ValidadorArgumento.validarObligatorio(numeroDePreguntas, "El numero de pregunta es obligatorio");
    ValidadorArgumento.validarObligatorio(activo, "El estado del examen es obligatorio");
    return new Examen(pregunta,titulo,descripcion,puntosMaximos,numeroDePreguntas,activo);
  }

  public Long getExamenId() {
    return examenId;
  }

  public Pregunta getPregunta() {
    return pregunta;
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
}
