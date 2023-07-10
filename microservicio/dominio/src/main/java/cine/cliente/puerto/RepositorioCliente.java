package cine.cliente.puerto;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    boolean existe (String nombre);

    Cliente obtener(Long id);

    ClienteDatosPrincipalesDTO obtenerDatosPrincipales(Long id);

    void eliminar(Long id);
    void actualizar(Cliente cliente);

    boolean existePorId(Long id);
}
