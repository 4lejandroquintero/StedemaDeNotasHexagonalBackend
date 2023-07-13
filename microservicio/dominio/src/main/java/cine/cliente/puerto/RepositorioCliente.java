package cine.cliente.puerto;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    Cliente obtener(Long id);

}
