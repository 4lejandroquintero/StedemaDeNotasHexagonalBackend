package cine.pago;

import cine.factura.FacturaTestDataBuilder;
import cine.factura.modelo.entidad.Factura;
import cine.pago.entidad.Pago;

import java.math.BigDecimal;

public class PagoTestDataBuilder {
    private Long idPago;
    private Factura factura;
    private BigDecimal valorAPagar;
    private BigDecimal devuelta;

    public PagoTestDataBuilder conPagoPorDefecto() {
        this.idPago = 2L;
        this.factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        this.valorAPagar = BigDecimal.valueOf(85000);
        this.devuelta = BigDecimal.valueOf(2500);
        return this;
    }

    public PagoTestDataBuilder conIdPago(Long idPago) {
        this.idPago = idPago;
        return this;
    }

    public PagoTestDataBuilder conFactura(Factura factura) {
        this.factura = factura;
        return this;
    }

    public PagoTestDataBuilder conValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }

    public PagoTestDataBuilder conDevuelta(BigDecimal devuelta) {
        this.devuelta = devuelta;
        return this;
    }

    public Pago crear(){
        return Pago.crear(new SolicitudRealizarPagoTestDataBuilder().conFactura(factura).conValorAPagar(valorAPagar).construir());
    }

    public Pago reconstruir(){
        return Pago.reconstruir(idPago, factura, valorAPagar, devuelta);
    }
}
