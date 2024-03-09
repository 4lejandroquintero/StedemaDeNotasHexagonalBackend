package sistemaNotas.pregunta.comando;

public class ComandoControladorPreguntaTestDataBuilder {
    private Long preguntaId;
    private String contenido;
    private String imagen;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuestaDada;
    private String respuesta;

    public ComandoControladorPreguntaTestDataBuilder conPreguntaPorDefecto() {
        this.preguntaId = 2L;
        this.contenido = "Ant Man";
        this.imagen = "Pelicula de Superheroes";
        this.opcion1 = "urlImagen";
        this.opcion2 = "+12";
        this.opcion3 = "+12";
        this.opcion4 = "+12";
        this.respuestaDada = "+12";
        this.respuesta = "+12";
        return this;
    }
    public ComandoSolicitudCrearPregunta construir (){
        return new ComandoSolicitudCrearPregunta(preguntaId,contenido,imagen,opcion1,opcion2, opcion3, opcion4, respuestaDada, respuesta);
    }
}
