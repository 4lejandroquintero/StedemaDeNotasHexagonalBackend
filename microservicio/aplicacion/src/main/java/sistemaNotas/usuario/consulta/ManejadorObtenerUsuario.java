package sistemaNotas.usuario.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosCompletos;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.usuario.puerto.dao.UsuarioDao;

@Component
public class ManejadorObtenerUsuario {

  private final UsuarioDao usuarioDao;

  public ManejadorObtenerUsuario(UsuarioDao usuarioDao) {
    this.usuarioDao = usuarioDao;
  }

  public UsuarioDatosPrincipalesDTO ejecutar(Long id){
    return usuarioDao.obtenerDatosUsuarioID(id);
  }

  public UsuarioDatosCompletos obtener(Long id) {
    return usuarioDao.obtenerFullDatosUsuarioID(id);
  }
}
