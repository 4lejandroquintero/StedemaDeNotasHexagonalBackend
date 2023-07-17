package cine.pago.comando;

import java.math.BigDecimal;

public class ComandoControladorPagoTestDataBuilder {
    Long idFactura;
    BigDecimal valorAPagar;

    public ComandoControladorPagoTestDataBuilder comandoPagoPorDefecto() {
        this.idFactura = 2L;
        this.valorAPagar = BigDecimal.valueOf(40000);
        return this;
    }

    public ComandoControladorPagoTestDataBuilder conValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }

    public ComandoRealizarPago construir(){
        return new ComandoRealizarPago(idFactura, valorAPagar);
    }
}
