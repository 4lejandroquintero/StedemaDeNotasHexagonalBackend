package cine.funcion.comando;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoControladorFuncionTestDataBuilder {
    private Long idPelicula;
    private String nombreTeatro;
    private String salaFuncion;
    private LocalDate diaFuncion;
    private LocalTime horaFuncion;
    private BigDecimal valorFuncion;
    private String categoriaAudioFuncion;
    private String categoriaSubtitulosFuncion;
    private String categoriaVisualFuncion;

    public ComandoControladorFuncionTestDataBuilder funcionPorDefecto() {
        this.idPelicula = 1L;
        this.nombreTeatro = "Cinepolis";
        this.salaFuncion = "Q1";
        this.diaFuncion = LocalDate.of(2023,6,30);
        this.horaFuncion = LocalTime.of(8,30);
        this.valorFuncion = BigDecimal.valueOf(20000);
        this.categoriaAudioFuncion = "Doblaje Latino";
        this.categoriaSubtitulosFuncion = "Sin Subtitulos";
        this.categoriaVisualFuncion = "2D";
        return this;

    }


    public ComandoCrearFuncion construir(){
        return new ComandoCrearFuncion(idPelicula,nombreTeatro,salaFuncion,diaFuncion,horaFuncion,valorFuncion,categoriaAudioFuncion,categoriaSubtitulosFuncion,categoriaVisualFuncion);
    }
}
