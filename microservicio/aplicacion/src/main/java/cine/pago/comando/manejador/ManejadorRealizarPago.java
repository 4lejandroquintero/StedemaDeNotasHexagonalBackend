package cine.pago.comando.manejador;

import cine.ComandoRespuesta;
import cine.manejador.ManejadorComandoRespuesta;
import cine.pago.comando.ComandoRealizarPago;
import cine.pago.comando.fabrica.FabricaRealizarPago;
import cine.pago.servicio.ServicioRealizarPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRealizarPago implements ManejadorComandoRespuesta<ComandoRealizarPago, ComandoRespuesta<Long>> {
    private final FabricaRealizarPago fabricaRealizarPago;
    private final ServicioRealizarPago servicioRealizarPago;

    public ManejadorRealizarPago(FabricaRealizarPago fabricaRealizarPago, ServicioRealizarPago servicioRealizarPago) {
        this.fabricaRealizarPago = fabricaRealizarPago;
        this.servicioRealizarPago = servicioRealizarPago;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoRealizarPago comandoRealizarPago) {
        return new ComandoRespuesta<>(servicioRealizarPago.ejecutar(fabricaRealizarPago.crear(comandoRealizarPago)));
    }
}
