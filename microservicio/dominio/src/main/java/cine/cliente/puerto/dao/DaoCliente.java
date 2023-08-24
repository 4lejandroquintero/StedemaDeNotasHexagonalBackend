package cine.cliente.puerto.dao;

import cine.cliente.modelo.dto.ClienteDatosCompletos;
import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.modelo.entidad.Cliente;

import java.util.List;

public interface DaoCliente {
    List<ClienteDatosPrincipalesDTO> obtenerDatosClientes();
    ClienteDatosPrincipalesDTO obtenerDatosClientePorID(Long id);

    ClienteDatosCompletos obtenerFullDatosClientePorID(Long id);
}
