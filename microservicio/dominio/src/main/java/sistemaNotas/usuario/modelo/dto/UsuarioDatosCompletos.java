package sistemaNotas.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDatosCompletos {
  private Long id;
  private String username;
  private String password;
  private String nombre;
  private String apellido;
  private String email;
  private String telefono;
  private boolean enabled = true;
  private String perfil;

}
