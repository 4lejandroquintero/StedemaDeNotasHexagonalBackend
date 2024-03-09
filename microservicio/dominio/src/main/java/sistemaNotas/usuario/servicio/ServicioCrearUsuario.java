package sistemaNotas.usuario.servicio;

import sistemaNotas.usuario.modelo.entidad.Usuario;
import sistemaNotas.usuario.puerto.UsuarioRepositorio;

public class ServicioCrearUsuario {

  private final UsuarioRepositorio usuarioRepositorio;

  public ServicioCrearUsuario(UsuarioRepositorio usuarioRepositorio) {
    this.usuarioRepositorio = usuarioRepositorio;
  }

  public Long ejecutar(Usuario usuario) {
    return this.usuarioRepositorio.crear(usuario);
  }
}
