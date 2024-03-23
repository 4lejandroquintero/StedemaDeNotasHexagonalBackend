package sistemaNotas.examen;

import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.pregunta.PreguntaTestDataBuilder;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;

public class ExamenTestDataBuilder {
    private Long examenId;
    private Pregunta pregunta;
    private String titulo;
    private String descripcion;
    private String puntosMaximos;
    private String numeroDePreguntas;
    private boolean activo = false;

    public ExamenTestDataBuilder crearExamenPorDefecto() {
        this.examenId = 1L;
        this.pregunta = new PreguntaTestDataBuilder().crearPreguntaPorDefecto().reconstruir();
        this.titulo = "Cinemark";
        this.descripcion = "01";
        this.puntosMaximos = "Doblaje Latino";
        this.numeroDePreguntas = "Sin Subtitulos";
        this.activo = true;
        return this;
    }

    public ExamenTestDataBuilder conIdExamen(Long examenId) {
        this.examenId = examenId;
        return this;
    }

    public ExamenTestDataBuilder conPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public ExamenTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ExamenTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ExamenTestDataBuilder conPuntosMaximos(String puntosMaximos) {
        this.puntosMaximos = puntosMaximos;
        return this;
    }

    public ExamenTestDataBuilder conNumeroDePreguntas(String numeroDePreguntas) {
        this.numeroDePreguntas = numeroDePreguntas;
        return this;
    }

    public ExamenTestDataBuilder isActivo(boolean activo) {
        this.activo = activo;
        return this;
    }

    public Examen crear(){
        return Examen.crear(pregunta, titulo, descripcion, puntosMaximos, numeroDePreguntas,activo);
    }
    public Examen reconstruir(){
        return Examen.reconstruir(examenId, pregunta, titulo, descripcion, puntosMaximos, numeroDePreguntas,activo);
    }
}
