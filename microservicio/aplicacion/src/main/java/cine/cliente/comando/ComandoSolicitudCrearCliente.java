package cine.cliente.comando;

import cine.cliente.modelo.entidad.Membresia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearCliente {
    private Long idCliente;
    private String nombre;
    private String email;
    private String contrasena;
    private String documentoIdentidad;
    private Membresia tipoMembresia;
}
