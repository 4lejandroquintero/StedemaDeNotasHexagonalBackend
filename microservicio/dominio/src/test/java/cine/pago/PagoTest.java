package cine.pago;

import cine.factura.FacturaTestDataBuilder;
import cine.factura.modelo.entidad.Factura;
import cine.pago.entidad.Pago;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PagoTest {
    @Test
    void deberiaRealizarPagoCorrectamente(){
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        Pago pago = new PagoTestDataBuilder().conFactura(factura).conValorAPagar(BigDecimal.valueOf(85000)).crear();

        Assertions.assertEquals(2L, pago.getIdPago());
        Assertions.assertEquals(factura, pago.getFactura());
        Assertions.assertEquals(BigDecimal.valueOf(85000), pago.getValorAPagar());
        Assertions.assertEquals(BigDecimal.valueOf(2500), pago.getDevuelta());
    }
}
