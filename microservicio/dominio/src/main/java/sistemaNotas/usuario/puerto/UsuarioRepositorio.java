package sistemaNotas.usuario.puerto;

import sistemaNotas.usuario.modelo.entidad.Usuario;

public interface UsuarioRepositorio {

  Long crear(Usuario usuario);

  Usuario consultar(String email);
  Usuario obtener(Long id);
}
