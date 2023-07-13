package cine.factura.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudFacturar {
    private Long idCliente;
    private Long idBoleto;
}
