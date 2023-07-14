package cine.factura.modelo.dto;

import cine.boleto.entidad.Boleto;
import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.factura.modelo.entidad.EstadoFactura;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter

public class ResumenFacturaDTO {
    private Long idFactura;
    private Boleto boleto;
    private ClienteDatosPrincipalesDTO cliente;
    private LocalDate fechaFactura;
    private EstadoFactura estadoFactura;
    private BigDecimal valorDeBoletos;
    private BigDecimal descuento;
    private BigDecimal valorTotal;
}
