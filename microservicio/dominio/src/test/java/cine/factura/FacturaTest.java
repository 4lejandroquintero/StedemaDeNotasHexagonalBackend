package cine.factura;

import cine.boleto.BoletoTestDataBuilder;
import cine.boleto.entidad.Boleto;
import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.modelo.entidad.Membresia;
import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorInvalido;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
import cine.factura.modelo.dto.ResumenFacturaDTO;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.modelo.entidad.Factura;
import cine.funcion.FuncionTestDataBuilder;
import cine.funcion.modelo.entidad.Funcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

class FacturaTest {
    @Test
    void deberiaCrearFacturaCorrectamenteConClienteMembresiaEsmeralda(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().conTipoMembresia(Membresia.ESMERALDA).reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).reconstruir();
        factura.obtenerValorTodosBoletos(boleto);
        factura.descuentosBoleto();

        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.15));
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());
    }
    @Test
    void deberiaCrearFacturaCorrectamenteConClienteMembresiaRuby(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).reconstruir();
        factura.obtenerValorTodosBoletos(boleto);
        factura.descuentosBoleto();

        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.25));
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());
    }
    @Test
    void deberiaCrearFacturaCorrectamenteConClienteMembresiaZafiro(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().conTipoMembresia(Membresia.ZAFIRO).reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).reconstruir();
        factura.obtenerValorTodosBoletos(boleto);
        factura.descuentosBoleto();

        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.35));
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());
    }

    @Test
    void construirDTOFacturaCorrectamente(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        ResumenFacturaDTO factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).construirDTO();
        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.25)).setScale(0, RoundingMode.DOWN);
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());

    }

    @Test
    void reconstruirFacturaSinIdFacturaDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new FacturaTestDataBuilder().conFacturaPorDefecto().conIdFactura(null).reconstruir(),
                ExcepcionValorObligatorio.class,"Se requiere una ID de Factura");
    }
    @Test
    void reconstruirFacturaSinBoletoDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new FacturaTestDataBuilder().conFacturaPorDefecto().conBoleto(null).reconstruir(),
                ExcepcionValorObligatorio.class,"No se puede crear una factura sin boleto");
    }
    @Test
    void reconstruirFacturaSinClienteDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(null).reconstruir(),
                ExcepcionValorObligatorio.class,"El cliente es necesario para generar factura");
    }
    @Test
    void reconstruirFacturaConValorMenorDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new FacturaTestDataBuilder().conFacturaPorDefecto().conValorDeBoletos(BigDecimal.valueOf(-1000)).reconstruir(),
                ExcepcionValorInvalido.class,"El total no puede ser menor a cero");
    }

    @Test
    void crearFacturaSinBoletoDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new SolicitudFacturarTestDataBuilder().crearSinBoleto(),
                ExcepcionValorObligatorio.class,"No se puede generar factura sin boletos.");
    }
    @Test
    void crearFacturaSinClienteDeberiaLanzarExcepcion(){
        BasePrueba.assertThrows(()-> new SolicitudFacturarTestDataBuilder().crearSinCliente(),
                ExcepcionValorObligatorio.class,"El cliente es requerido para generar una factura");
    }
    @Test
    void deberiaCrearFacturaCorrectamenteAplicandoDescuentoHappyDays(){
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().conDiaFuncion(LocalDate.of(2023,7,19)).reconstruir();
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(funcion).reconstruir();
        Factura factura = new FacturaTestDataBuilder().conFacturaPorDefecto().conCliente(cliente)
                .conBoleto(boleto).reconstruir();
        factura.obtenerValorTodosBoletos(boleto);
        factura.descuentosBoleto();

        Assertions.assertEquals(1L, factura.getIdFactura());
        Assertions.assertEquals(boleto, factura.getBoleto());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(LocalDate.of(2023, 2, 12), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        BigDecimal valorBoletos = BigDecimal.valueOf(boleto.getCantidadAsientos()).multiply(boleto.obtenerValorFuncion());
        Assertions.assertEquals(valorBoletos, factura.getValorDeBoletos());
        BigDecimal descuento = valorBoletos.multiply(BigDecimal.valueOf(0.4));
        Assertions.assertEquals(descuento , factura.getDescuento());
        Assertions.assertEquals(valorBoletos.subtract(descuento), factura.getValorTotal());
    }


}
