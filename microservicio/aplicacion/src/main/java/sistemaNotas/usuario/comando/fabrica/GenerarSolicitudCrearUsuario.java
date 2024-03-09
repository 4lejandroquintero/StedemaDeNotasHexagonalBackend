package sistemaNotas.usuario.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.usuario.comando.ComandoSolicitudCrearUsuario;
import sistemaNotas.usuario.modelo.entidad.Usuario;

@Component
public class GenerarSolicitudCrearUsuario {
  public Usuario crear(ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario){
    return new Usuario(comandoSolicitudCrearUsuario.getUsername(), comandoSolicitudCrearUsuario.getPassword(),
      comandoSolicitudCrearUsuario.getNombre(), comandoSolicitudCrearUsuario.getApellido(),
      comandoSolicitudCrearUsuario.getEmail(), comandoSolicitudCrearUsuario.getTelefono(),
      comandoSolicitudCrearUsuario.isEnabled(), comandoSolicitudCrearUsuario.getRol());
  }
}
