package cine.cliente.consulta;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCliente {

    private final DaoCliente daoCliente;

    public ManejadorObtenerCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public ClienteDatosPrincipalesDTO ejecutar(Long id){
        return daoCliente.obtenerDatosClientePorID(id);
    }
}
