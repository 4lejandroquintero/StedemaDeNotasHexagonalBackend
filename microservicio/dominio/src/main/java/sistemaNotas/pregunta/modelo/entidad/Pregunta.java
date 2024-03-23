package sistemaNotas.pregunta.modelo.entidad;

import sistemaNotas.dominio.ValidadorArgumento;
import sistemaNotas.examen.modelo.entidad.Examen;

public class Pregunta {
  private Long preguntaId;
  private Examen examen;
  private String contenido;
  private String imagen;
  private String opcion1;
  private String opcion2;
  private String opcion3;
  private String opcion4;
  private String respuestaDada;
  private String respuesta;

  public Pregunta(Long preguntaId, Examen examen, String contenido, String imagen, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaDada, String respuesta) {
    this.preguntaId = preguntaId;
    this.examen = examen;
    this.contenido = contenido;
    this.imagen = imagen;
    this.opcion1 = opcion1;
    this.opcion2 = opcion2;
    this.opcion3 = opcion3;
    this.opcion4 = opcion4;
    this.respuestaDada = respuestaDada;
    this.respuesta = respuesta;
  }

  public Pregunta(Examen examen, String contenido, String imagen, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaDada, String respuesta) {
    this.examen = examen;
    this.contenido = contenido;
    this.imagen = imagen;
    this.opcion1 = opcion1;
    this.opcion2 = opcion2;
    this.opcion3 = opcion3;
    this.opcion4 = opcion4;
    this.respuestaDada = respuestaDada;
    this.respuesta = respuesta;
  }

  public static Pregunta reconstruir(Long preguntaId, Examen examen, String contenido, String imagen, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaDada, String respuesta) {
    ValidadorArgumento.validarObligatorio(preguntaId, "Se debe ingresar el id de la pregunta");
    ValidadorArgumento.validarObligatorio(examen, "Se debe ingresar el examen de la pregunta");
    ValidadorArgumento.validarObligatorio(contenido, "Se debe ingresar el contenido de la pregunta");
    ValidadorArgumento.validarObligatorio(imagen, "Se debe ingresar la imagen de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion1, "Se debe ingresar la opción 1 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion2, "Se debe ingresar la opción 2 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion3, "Se debe ingresar la opción 3 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion4, "Se debe ingresar la opción 4 de la pregunta");
    ValidadorArgumento.validarObligatorio(respuestaDada, "Se debe registrar una respuesta");
    ValidadorArgumento.validarObligatorio(respuesta, "Se debe registrar la respuesta");
    return new Pregunta(preguntaId,examen, contenido, imagen, opcion1, opcion2, opcion3, opcion4, respuestaDada, respuesta);
  }

  public static Pregunta crear(Examen examen, String contenido, String imagen, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaDada, String respuesta) {
    ValidadorArgumento.validarObligatorio(examen, "Se debe ingresar el examen de la pregunta");
    ValidadorArgumento.validarObligatorio(contenido, "Se debe ingresar el contenido de la pregunta");
    ValidadorArgumento.validarObligatorio(imagen, "Se debe ingresar la imagen de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion1, "Se debe ingresar la opción 1 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion2, "Se debe ingresar la opción 2 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion3, "Se debe ingresar la opción 3 de la pregunta");
    ValidadorArgumento.validarObligatorio(opcion4, "Se debe ingresar la opción 4 de la pregunta");
    ValidadorArgumento.validarObligatorio(respuestaDada, "Se debe registrar una respuesta");
    ValidadorArgumento.validarObligatorio(respuesta, "Se debe registrar la respuesta");
    return new Pregunta(examen, contenido, imagen, opcion1, opcion2, opcion3, opcion4, respuestaDada, respuesta);
  }

  public Long getPreguntaId() {
    return preguntaId;
  }

  public Examen getExamen() {
    return examen;
  }

  public String getContenido() {
    return contenido;
  }

  public String getImagen() {
    return imagen;
  }

  public String getOpcion1() {
    return opcion1;
  }

  public String getOpcion2() {
    return opcion2;
  }

  public String getOpcion3() {
    return opcion3;
  }

  public String getOpcion4() {
    return opcion4;
  }

  public String getRespuestaDada() {
    return respuestaDada;
  }

  public String getRespuesta() {
    return respuesta;
  }
}

