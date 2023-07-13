package cine.pago.entidad;

import cine.dominio.ValidadorArgumento;
import cine.factura.modelo.entidad.Factura;

import java.math.BigDecimal;

public class Pago {
    private Long idPago;
    private Factura factura;
    private BigDecimal valorAPagar;
    private BigDecimal devuelta;

    public Pago(Factura factura, BigDecimal valorAPagar) {
        this.factura = factura;
        this.valorAPagar = valorAPagar;
        obtenerDevuelta();
    }

    public Pago(Long idPago, Factura factura, BigDecimal valorAPagar, BigDecimal devuelta) {
        this.idPago = idPago;
        this.factura = factura;
        this.valorAPagar = valorAPagar;
        this.devuelta = devuelta;
    }

    public static Pago reconstruir(Long idPago, Factura factura, BigDecimal valorAPagar, BigDecimal devuelta) {
        ValidadorArgumento.validarObligatorio(idPago, "Debes ingresar el id del pago");
        ValidadorArgumento.validarObligatorio(factura, "Debes ingresar el id del pago");
        ValidadorArgumento.validarObligatorio(valorAPagar, "Debes ingresar el id del pago");
        return new Pago(idPago, factura, valorAPagar, devuelta);
    }

    public static Pago crear(SolicitudRealizarPago solicitudRealizarPago){
        ValidadorArgumento.validarObligatorio(solicitudRealizarPago.getFactura(), "Debes ingresar el id de la factura para pagar");
        ValidadorArgumento.validarObligatorio(solicitudRealizarPago.getValorAPagar(), "Debes ingresar el valor a pagar");
        return new Pago(solicitudRealizarPago.getFactura(), solicitudRealizarPago.getValorAPagar());
    }

    public Factura getFactura() {
        return factura;
    }
    public BigDecimal getValorAPagar() {
        return valorAPagar;
    }
    public BigDecimal getDevuelta() {
        return devuelta;
    }
    private void obtenerDevuelta(){
        this.devuelta = getValorAPagar().subtract(this.factura.getValorTotal());
    }

    public Long getIdPago() {
        return idPago;
    }
}
