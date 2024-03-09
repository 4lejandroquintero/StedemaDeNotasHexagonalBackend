package sistemaNotas.categoria.comando.manejador;

import org.springframework.stereotype.Component;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.categoria.comando.ComandoSolicitudCrearCategoria;
import sistemaNotas.categoria.comando.fabrica.GenerarSolicitudCrearCategoria;
import sistemaNotas.categoria.servicio.ServicioCrearCategoria;
import sistemaNotas.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearCategoria implements ManejadorComandoRespuesta<ComandoSolicitudCrearCategoria, ComandoRespuesta<Long>> {

  private final ServicioCrearCategoria servicioCrearCategoria;
  private final GenerarSolicitudCrearCategoria generarSolicitudCrearCategoria;

  public ManejadorCrearCategoria(ServicioCrearCategoria servicioCrearCategoria, GenerarSolicitudCrearCategoria generarSolicitudCrearCategoria) {
    this.servicioCrearCategoria = servicioCrearCategoria;
    this.generarSolicitudCrearCategoria = generarSolicitudCrearCategoria;
  }

  @Override
  public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearCategoria comandoSolicitudCrearCategoria) {
    return new ComandoRespuesta<>(servicioCrearCategoria.ejecutar(generarSolicitudCrearCategoria.crear(comandoSolicitudCrearCategoria)));
  }
}
