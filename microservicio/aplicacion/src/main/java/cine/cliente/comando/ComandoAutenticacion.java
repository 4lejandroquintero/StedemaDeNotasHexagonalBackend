package cine.cliente.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoAutenticacion {
    private String correo;
    private String contrasena;
}
