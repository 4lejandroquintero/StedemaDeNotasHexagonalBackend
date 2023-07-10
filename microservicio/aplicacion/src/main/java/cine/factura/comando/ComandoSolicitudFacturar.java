package cine.factura.comando;

import cine.boleto.entidad.Boleto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudFacturar {
    private Long idCliente;
    private Long idBoleto;
}
