package cine.cliente.modelo.dto;

import cine.cliente.modelo.entidad.Membresia;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClienteDatosPrincipalesDTO {
    private Long id;
    private String nombre;
    private String documentoIdentidad;
    private Membresia tipoMembresia;

}
