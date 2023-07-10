package cine.pago.entidad;
import cine.factura.modelo.entidad.Factura;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class SolicitudRealizarPago {
    private Factura factura;
    private BigDecimal valorAPagar;
}
