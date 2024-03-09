package sistemaNotas.usuario.puerto.dao;

import sistemaNotas.usuario.modelo.dto.UsuarioDatosCompletos;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;

import java.util.List;

public interface UsuarioDao {
  List<UsuarioDatosPrincipalesDTO> obtenerDatosUsuarios();
  UsuarioDatosPrincipalesDTO obtenerDatosUsuarioID(Long id);

  UsuarioDatosCompletos obtenerFullDatosUsuarioID(Long id);
}
