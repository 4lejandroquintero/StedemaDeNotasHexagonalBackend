package sistemaNotas.usuario.comando.manejador;

import org.springframework.stereotype.Component;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.manejador.ManejadorComandoRespuesta;
import sistemaNotas.usuario.comando.ComandoSolicitudCrearUsuario;
import sistemaNotas.usuario.comando.fabrica.GenerarSolicitudCrearUsuario;
import sistemaNotas.usuario.servicio.ServicioCrearUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoSolicitudCrearUsuario, ComandoRespuesta<Long>> {

  private final GenerarSolicitudCrearUsuario generarSolicitudCrearUsuario;

  private final ServicioCrearUsuario servicioCrearUsuario;

  public ManejadorCrearUsuario(GenerarSolicitudCrearUsuario generarSolicitudCrearUsuario, ServicioCrearUsuario servicioCrearUsuario) {
    this.generarSolicitudCrearUsuario = generarSolicitudCrearUsuario;
    this.servicioCrearUsuario = servicioCrearUsuario;
  }


  @Override
  public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario) {
    return new ComandoRespuesta<>(servicioCrearUsuario
      .ejecutar(generarSolicitudCrearUsuario.crear(comandoSolicitudCrearUsuario)));
  }
}
