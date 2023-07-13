package cine.pago;

import cine.factura.modelo.entidad.Factura;
import cine.pago.entidad.SolicitudRealizarPago;

import java.math.BigDecimal;

public class SolicitudRealizarPagoTestDataBuilder {
    Factura factura;
    BigDecimal valorAPagar;

    public SolicitudRealizarPagoTestDataBuilder() {
    }

    public SolicitudRealizarPagoTestDataBuilder conFactura(Factura factura) {
        this.factura = factura;
        return this;
    }

    public SolicitudRealizarPagoTestDataBuilder conValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }
    public SolicitudRealizarPago construir(){
        return new SolicitudRealizarPago(factura, valorAPagar);
    }
}
