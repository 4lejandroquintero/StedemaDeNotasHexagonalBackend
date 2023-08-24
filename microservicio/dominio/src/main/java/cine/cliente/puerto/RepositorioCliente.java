package cine.cliente.puerto;

import cine.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    Cliente consultar(String email);
    Cliente obtener(Long id);

}
