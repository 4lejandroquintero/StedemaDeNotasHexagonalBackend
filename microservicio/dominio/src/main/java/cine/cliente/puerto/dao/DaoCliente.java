package cine.cliente.puerto.dao;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;

import java.util.List;

public interface DaoCliente {
    List<ClienteDatosPrincipalesDTO> obtenerDatosClientes();
    ClienteDatosPrincipalesDTO obtenerDatosClientePorID(Long id);
}
