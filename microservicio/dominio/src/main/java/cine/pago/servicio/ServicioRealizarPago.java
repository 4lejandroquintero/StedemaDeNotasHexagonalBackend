package cine.pago.servicio;

import cine.pago.entidad.Pago;
import cine.pago.entidad.SolicitudRealizarPago;
import cine.pago.puerto.RepositorioPago;

public class ServicioRealizarPago {
    private final RepositorioPago repositorioPago;

    public ServicioRealizarPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public Long ejecutar(SolicitudRealizarPago solicitudRealizarPago){
        Pago pago = Pago.crear(solicitudRealizarPago);
        return repositorioPago.crear(pago);
    }

}
