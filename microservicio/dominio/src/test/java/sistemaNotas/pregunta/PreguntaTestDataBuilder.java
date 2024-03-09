package sistemaNotas.pregunta;

import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.entidad.dto.PreguntaDTO;

public class PreguntaTestDataBuilder {
    private Long preguntaId;
    private String contenido;
    private String imagen;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuestaDada;
    private String respuesta;

    public PreguntaTestDataBuilder crearPreguntaPorDefecto() {
        this.preguntaId = 1L;
        this.contenido = "Avengers: End Game";
        this.imagen = "Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos";
        this.opcion1 = "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg";
        this.opcion2 = "+13";
        this.opcion3 = "+13";
        this.opcion4 = "+13";
        this.respuestaDada = "+13";
        this.respuesta = "+13";
        return this;
    }

    public PreguntaTestDataBuilder conPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
        return this;
    }

    public PreguntaTestDataBuilder conContenido(String contenido) {
        this.contenido = contenido;
        return this;
    }

    public PreguntaTestDataBuilder conImagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public PreguntaTestDataBuilder conOpcion1(String opcion1) {
        this.opcion1 = opcion1;
        return this;
    }

    public PreguntaTestDataBuilder conOpcion2(String opcion2) {
        this.opcion2 = opcion2;
        return this;
    }

    public PreguntaTestDataBuilder conOpcion3(String opcion3) {
        this.opcion3 = opcion3;
        return this;
    }

    public PreguntaTestDataBuilder conOpcion4(String opcion4) {
        this.opcion4 = opcion4;
        return this;
    }

    public PreguntaTestDataBuilder conRespuestaDada(String respuestaDada) {
        this.respuestaDada = respuestaDada;
        return this;
    }

    public PreguntaTestDataBuilder conRespuesta(String respuesta) {
        this.respuesta = respuesta;
        return this;
    }

    public Pregunta reconstruir(){
        return Pregunta.reconstruir(preguntaId,contenido,imagen,opcion1,opcion2,opcion3,opcion4,respuestaDada,respuesta);
    }

    public PreguntaDTO crearDTO(){
        return new PreguntaDTO(preguntaId,contenido,imagen,opcion1,opcion2,opcion3,opcion4,respuestaDada,respuesta);
    }

}
