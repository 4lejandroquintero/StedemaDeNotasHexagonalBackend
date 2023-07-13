package cine.factura;

import cine.boleto.BoletoTestDataBuilder;
import cine.boleto.entidad.Boleto;
import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.modelo.entidad.Cliente;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.modelo.entidad.Factura;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FacturaTestDataBuilder {
    private Long idFactura;
    private Boleto boleto;
    private Cliente cliente;
    private LocalDate fechaFactura;
    private EstadoFactura estadoFactura;
    private BigDecimal valorDeBoletos;
    private BigDecimal descuento;
    private BigDecimal valorTotal;

    public FacturaTestDataBuilder conFacturaPorDefecto() {
        this.idFactura = 1L;
        this.boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        this.cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        this.fechaFactura = LocalDate.of(2023,2,12);
        this.estadoFactura = EstadoFactura.PENDIENTE;
        this.valorDeBoletos = BigDecimal.valueOf(110000);
        this.descuento = BigDecimal.valueOf(27500);
        this.valorTotal = BigDecimal.valueOf(82500);
        return this;
    }

    public FacturaTestDataBuilder conIdFactura(Long idFactura) {
        this.idFactura = idFactura;
        return this;
    }

    public FacturaTestDataBuilder conBoleto(Boleto boleto) {
        this.boleto = boleto;
        return this;
    }

    public FacturaTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public FacturaTestDataBuilder conFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
        return this;
    }

    public FacturaTestDataBuilder conEstadoFactura(EstadoFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
        return this;
    }

    public FacturaTestDataBuilder conValorDeBoletos(BigDecimal valorDeBoletos) {
        this.valorDeBoletos = valorDeBoletos;
        return this;
    }

    public FacturaTestDataBuilder conDescuento(BigDecimal descuento) {
        this.descuento = descuento;
        return this;
    }

    public FacturaTestDataBuilder conValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Factura reconstruir(){
        return Factura.reconstruir(idFactura,boleto,cliente,fechaFactura, estadoFactura,valorDeBoletos, descuento, valorTotal);
    }

}