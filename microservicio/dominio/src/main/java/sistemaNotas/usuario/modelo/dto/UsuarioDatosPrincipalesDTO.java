package sistemaNotas.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sistemaNotas.usuario.modelo.entidad.Rol;

@AllArgsConstructor
@Getter
public class UsuarioDatosPrincipalesDTO {
  private Long id;
  private String username;
  private String password;
  private Rol tipoRol;
}
