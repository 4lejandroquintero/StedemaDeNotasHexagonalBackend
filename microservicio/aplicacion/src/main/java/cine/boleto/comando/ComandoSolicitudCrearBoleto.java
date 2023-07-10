package cine.boleto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearBoleto {
    private Long idBoleto;
    private Integer cantidadAsientos;
    private String numeroAsientos;
    private Long idFuncion;
}
