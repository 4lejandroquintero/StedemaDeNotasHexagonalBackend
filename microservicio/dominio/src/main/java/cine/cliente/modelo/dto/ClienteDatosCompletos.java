package cine.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDatosCompletos {
    private  Long idCliente;
    private  String nombre;
    private  String email;
    private  String contrasena;
    private  String documentoIdentidad;
    private String tipoMembresia;
}
