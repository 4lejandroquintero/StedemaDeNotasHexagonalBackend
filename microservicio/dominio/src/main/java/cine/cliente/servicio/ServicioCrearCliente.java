package cine.cliente.servicio;

import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.puerto.RepositorioCliente;
import cine.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {

    private static final String CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El/la cliente ya existe en el sistema";
    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    private void validarExistenciaPrevia(Cliente cliente){
        boolean existe = this.repositorioCliente.existe(cliente.getEmail());
        if (existe){
            throw new ExcepcionDuplicidad(CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public Long ejecutar(Cliente cliente){
        validarExistenciaPrevia(cliente);
        return this.repositorioCliente.crear(cliente);
    }
}
