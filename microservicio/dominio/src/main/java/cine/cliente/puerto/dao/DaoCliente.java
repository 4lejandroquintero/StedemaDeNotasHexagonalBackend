package cine.cliente.puerto.dao;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;

import java.util.List;
import java.util.Optional;

public interface DaoCliente {
    List<ClienteDatosPrincipalesDTO> obtenerDatosClientes();
    ClienteDatosPrincipalesDTO obtenerDatosClientePorID(Long id);
}
