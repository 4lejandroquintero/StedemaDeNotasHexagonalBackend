package cine.pago;

import cine.factura.FacturaTestDataBuilder;
import cine.factura.modelo.entidad.Factura;
import cine.pago.entidad.Pago;
import cine.pago.entidad.SolicitudRealizarPago;

import java.math.BigDecimal;

public class SolicitudRealizarPagoTestDataBuilder {
    Factura factura;
    BigDecimal valorAPagar;

    public SolicitudRealizarPagoTestDataBuilder() {
    }
    public SolicitudRealizarPagoTestDataBuilder solicitudRealizarPagoPorDefecto() {
        this.factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        this.valorAPagar = BigDecimal.valueOf(50000);
        return this;
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

    public Pago crearSinFactura() {
        return Pago.crear(new SolicitudRealizarPagoTestDataBuilder().solicitudRealizarPagoPorDefecto().conFactura(null).construir());
    }
    public Pago crearSinValorAPagar() {
        return Pago.crear(new SolicitudRealizarPagoTestDataBuilder().solicitudRealizarPagoPorDefecto().conValorAPagar(null).construir());
    }
    public Pago crearConValorMenorAPagar() {
        return Pago.crear(new SolicitudRealizarPagoTestDataBuilder().solicitudRealizarPagoPorDefecto().conValorAPagar(BigDecimal.valueOf(0)).construir());
    }
}
