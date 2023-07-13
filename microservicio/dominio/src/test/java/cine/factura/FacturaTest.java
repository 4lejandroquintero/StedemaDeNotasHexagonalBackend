package cine.factura;

import cine.boleto.BoletoTestDataBuilder;
import cine.boleto.entidad.Boleto;
import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.modelo.entidad.Cliente;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.modelo.entidad.Factura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

class FacturaTest {
    @Test
    void deberiaCrearFacturaCorrectamente(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).reconstruir();

        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.25)).setScale(0, RoundingMode.DOWN);
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());

    }
}
