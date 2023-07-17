package cine.pago;

import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorInvalido;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
import cine.factura.FacturaTestDataBuilder;
import cine.factura.SolicitudFacturarTestDataBuilder;
import cine.factura.modelo.entidad.Factura;
import cine.pago.entidad.Pago;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PagoTest {
    @Test
    void deberiaRealizarPagoCorrectamente(){
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        Pago pago = new PagoTestDataBuilder().conPagoPorDefecto().conFactura(factura).crear();
        pago.obtenerDevuelta();
        Assertions.assertEquals(factura, pago.getFactura());
        Assertions.assertEquals(BigDecimal.valueOf(85000), pago.getValorAPagar());
        Assertions.assertEquals(BigDecimal.valueOf(2500), pago.getDevuelta());
    }

    @Test
    void crearPagoSinFacturaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new SolicitudRealizarPagoTestDataBuilder().crearSinFactura(),
                ExcepcionValorObligatorio.class,"Debes ingresar el id de la factura para pagar");
    }

    @Test
    void crearPagoSinValorAPagarDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new SolicitudRealizarPagoTestDataBuilder().crearSinValorAPagar(),
                ExcepcionValorObligatorio.class,"Debes ingresar el valor a pagar");
    }
    @Test
    void crearPagoConUnValorMenorAlValorDeFacturaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new SolicitudRealizarPagoTestDataBuilder().crearConValorMenorAPagar(),
                ExcepcionValorInvalido.class,"El valor a pagar no puede ser menor al valor total de la factura");
    }

    @Test
    void deberiaReconstruirPagoCorrectamente(){
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        Pago pago = new PagoTestDataBuilder().conPagoPorDefecto().conValorAPagar(BigDecimal.valueOf(85000)).conFactura(factura).reconstruir();

        Assertions.assertEquals(2L, pago.getIdPago());
        Assertions.assertEquals(factura, pago.getFactura());
        Assertions.assertEquals(BigDecimal.valueOf(85000), pago.getValorAPagar());
        Assertions.assertEquals(BigDecimal.valueOf(2500), pago.getDevuelta());
    }
    @Test
    void reconstruirPagoSinIdPago_DeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(() -> new PagoTestDataBuilder().conPagoPorDefecto().conIdPago(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Debes ingresar el id del pago");
    }
    @Test
    void reconstruirPagoSinFactura_DeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(() -> new PagoTestDataBuilder().conPagoPorDefecto().conFactura(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Debes una factura para pago");
    }
    @Test
    void reconstruirPagoSinValorAPagar_DeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(() -> new PagoTestDataBuilder().conPagoPorDefecto().conValorAPagar(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Debes ingresar el valor a pagar");
    }

    @Test
    void generarSolicitudPagoCorrectamente(){
        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto().reconstruir();
        var solicitudPago = new SolicitudRealizarPagoTestDataBuilder().solicitudRealizarPagoPorDefecto().conFactura(factura).construir();

        Assertions.assertEquals(factura, solicitudPago.getFactura());
        Assertions.assertEquals(BigDecimal.valueOf(50000), solicitudPago.getValorAPagar());
    }
}
