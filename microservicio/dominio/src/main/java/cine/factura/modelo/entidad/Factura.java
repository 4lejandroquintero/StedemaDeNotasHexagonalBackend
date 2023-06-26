package cine.factura.modelo.entidad;

import cine.boleto.entidad.Boleto;
import cine.cliente.entidad.Cliente;

import java.math.BigDecimal;
import java.util.List;

public class Factura {
    private Long idFactura;
    private List<Boleto> boletos;
    private Cliente cliente;
    private EstadoFactura estadoFactura;
    private Integer valorDeBoletos;
    private Integer descuento;
    private BigDecimal valorTotal;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoFactura getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(EstadoFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Integer getValorDeBoletos() {
        return valorDeBoletos;
    }

    public void setValorDeBoletos(Integer valorDeBoletos) {
        this.valorDeBoletos = valorDeBoletos;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
