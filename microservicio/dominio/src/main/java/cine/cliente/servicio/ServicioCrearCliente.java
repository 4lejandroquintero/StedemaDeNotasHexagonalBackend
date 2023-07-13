package cine.cliente.servicio;

import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.puerto.RepositorioCliente;
import cine.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }
    public Long ejecutar(Cliente cliente){
        return this.repositorioCliente.crear(cliente);
    }
}
