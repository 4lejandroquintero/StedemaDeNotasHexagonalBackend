package cine.boleto.comando.manejador;

import cine.ComandoRespuesta;
import cine.boleto.comando.ComandoSolicitudCrearBoleto;
import cine.boleto.comando.fabrica.GenerarSolicitudCrearBoleto;
import cine.boleto.servicio.ServicioCrearBoleto;
import cine.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearBoleto implements ManejadorComandoRespuesta<ComandoSolicitudCrearBoleto, ComandoRespuesta<Long>> {

    private final ServicioCrearBoleto servicioCrearBoleto;
    private final GenerarSolicitudCrearBoleto generarSolicitudCrearBoleto;

    public ManejadorCrearBoleto(ServicioCrearBoleto servicioCrearBoleto, GenerarSolicitudCrearBoleto generarSolicitudCrearBoleto) {
        this.servicioCrearBoleto = servicioCrearBoleto;
        this.generarSolicitudCrearBoleto = generarSolicitudCrearBoleto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearBoleto comandoSolicitudCrearBoleto) {
        return new ComandoRespuesta<>(servicioCrearBoleto.ejecutar(generarSolicitudCrearBoleto.crear(comandoSolicitudCrearBoleto)));
    }
}
