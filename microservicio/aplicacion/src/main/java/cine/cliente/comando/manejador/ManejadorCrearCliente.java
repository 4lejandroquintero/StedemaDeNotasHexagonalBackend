package cine.cliente.comando.manejador;

import cine.ComandoRespuesta;
import cine.cliente.comando.ComandoSolicitudCrearCliente;
import cine.cliente.comando.fabrica.GenerarSolicitudCrearCliente;
import cine.cliente.servicio.ServicioCrearCliente;
import cine.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoSolicitudCrearCliente, ComandoRespuesta<Long>> {

    private final GenerarSolicitudCrearCliente generarSolicitudCrearCliente;

    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearCliente(GenerarSolicitudCrearCliente generarSolicitudCrearCliente, ServicioCrearCliente servicioCrearCliente) {
        this.generarSolicitudCrearCliente = generarSolicitudCrearCliente;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente) {
        return new ComandoRespuesta<>(servicioCrearCliente
                .ejecutar(generarSolicitudCrearCliente.crear(comandoSolicitudCrearCliente)));
    }
}
