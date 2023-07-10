package cine.cliente.consulta;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarClientes {
    private final DaoCliente daoCliente;

    public ManejadorConsultarClientes(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<ClienteDatosPrincipalesDTO> ejecutar(){
        return daoCliente.obtenerDatosClientes();
    }
}
