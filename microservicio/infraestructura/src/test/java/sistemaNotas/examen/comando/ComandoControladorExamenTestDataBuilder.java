package sistemaNotas.examen.comando;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoControladorExamenTestDataBuilder {
    private Long idPregunta;
    private String titulo;
    private String descripcion;
    private String puntosMaximos;
    private String numeroDePreguntas;
    private boolean activo = false;

    public ComandoControladorExamenTestDataBuilder examenPorDefecto() {
        this.idPregunta = 1L;
        this.titulo = "Cuerpo Humano";
        this.descripcion = "Conoce tu cuerpo humano";
        this.puntosMaximos = "10";
        this.numeroDePreguntas = "8";
        this.activo = true;
        return this;

    }


    public ComandoCrearExamen construir(){
        return new ComandoCrearExamen(idPregunta,titulo,descripcion,puntosMaximos,numeroDePreguntas,activo);
    }
}
