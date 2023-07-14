package cine.funcion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCrearFuncion {
    private Long idPelicula;
    private String nombreTeatro;
    private String salaFuncion;
    private LocalDate diaFuncion;
    private LocalTime horaFuncion;
    private BigDecimal valorFuncion;
    private String categoriaAudioFuncion;
    private String categoriaSubtitulosFuncion;
    private String categoriaVisualFuncion;
}
