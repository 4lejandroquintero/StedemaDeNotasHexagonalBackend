package sistemaNotas.usuario.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoAutenticacion {
  private String username;
  private String password;
}
