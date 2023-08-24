package cine.cliente.modelo.dto;

import cine.cliente.modelo.entidad.Membresia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAutenticadoDatos {
    private String token;
    private  Long idCliente;
    private  String nombre;
    private  String email;
    private  String contrasena;
    private  String documentoIdentidad;
    private String tipoMembresia;

}
