package cine.factura.modelo.dto;

import cine.factura.modelo.entidad.EstadoFactura;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter

public class ResumenFacturaDTO {
    private Long idFactura;
    private BigDecimal valorTotal;
    private EstadoFactura estadoFactura;
}
