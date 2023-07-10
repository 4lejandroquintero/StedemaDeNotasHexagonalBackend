package cine.factura.comando.manejador;

import cine.ComandoRespuesta;
import cine.factura.comando.ComandoSolicitudFacturar;
import cine.factura.comando.fabrica.FabricaSolicitudFacturar;
import cine.factura.servicio.ServicioFacturar;
import cine.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFacturar implements ManejadorComandoRespuesta<ComandoSolicitudFacturar, ComandoRespuesta<Long>> {
    private final FabricaSolicitudFacturar fabricaSolicitudFacturar;
    private final ServicioFacturar servicioFacturar;

    public ManejadorFacturar(FabricaSolicitudFacturar fabricaSolicitudFacturar, ServicioFacturar servicioFacturar) {
        this.fabricaSolicitudFacturar = fabricaSolicitudFacturar;
        this.servicioFacturar = servicioFacturar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return new ComandoRespuesta<>(servicioFacturar.ejecutar(fabricaSolicitudFacturar.crear(comandoSolicitudFacturar)));
    }
}
