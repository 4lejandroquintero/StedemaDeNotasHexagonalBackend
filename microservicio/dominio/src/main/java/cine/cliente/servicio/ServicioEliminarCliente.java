package cine.cliente.servicio;

import cine.cliente.puerto.RepositorioCliente;

public class ServicioEliminarCliente {
    private RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long idCliente){
        this.repositorioCliente.eliminar(idCliente);
    }
}
