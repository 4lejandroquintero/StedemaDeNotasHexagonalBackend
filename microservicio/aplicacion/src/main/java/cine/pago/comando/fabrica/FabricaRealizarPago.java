package cine.pago.comando.fabrica;

import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.pago.comando.ComandoRealizarPago;
import cine.pago.entidad.SolicitudRealizarPago;
import org.springframework.stereotype.Component;

@Component
public class FabricaRealizarPago {
    private final RepositorioFactura repositorioFactura;

    public FabricaRealizarPago(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public SolicitudRealizarPago crear(ComandoRealizarPago comandoRealizarPago){
        return new SolicitudRealizarPago(repositorioFactura.obtener(comandoRealizarPago.getIdFactura()), comandoRealizarPago.getValorAPagar());
    }
}
