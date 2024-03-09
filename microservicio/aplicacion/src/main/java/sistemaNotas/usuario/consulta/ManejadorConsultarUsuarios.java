package sistemaNotas.usuario.consulta;

import org.springframework.stereotype.Component;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.usuario.puerto.dao.UsuarioDao;

import java.util.List;

@Component
public class ManejadorConsultarUsuarios {
  private final UsuarioDao usuarioDao;

  public ManejadorConsultarUsuarios(UsuarioDao usuarioDao) {
    this.usuarioDao = usuarioDao;
  }

  public List<UsuarioDatosPrincipalesDTO> ejecutar(){
    return usuarioDao.obtenerDatosUsuarios();
  }

}
