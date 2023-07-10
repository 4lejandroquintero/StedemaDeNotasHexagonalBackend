package cine.cliente.comando.fabrica;

import cine.cliente.comando.ComandoSolicitudCrearCliente;
import cine.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearCliente {
    public Cliente crear(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente){
        return new Cliente(comandoSolicitudCrearCliente.getIdCliente(), comandoSolicitudCrearCliente.getNombre(),
                comandoSolicitudCrearCliente.getEmail(), comandoSolicitudCrearCliente.getContrasena(), comandoSolicitudCrearCliente.getDocumentoIdentidad(),
                comandoSolicitudCrearCliente.getTipoMembresia());
    }

}
