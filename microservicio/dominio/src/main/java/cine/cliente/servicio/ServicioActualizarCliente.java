package cine.cliente.servicio;

import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.puerto.RepositorioCliente;
import cine.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {
    private static final String CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El/La cliente no existe en el sistema";
    private RepositorioCliente repositorioCliente;


    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }


    public void ejecutar(Cliente cliente){
        validarExistenciaPrevia(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    private void validarExistenciaPrevia(Cliente cliente) {
        boolean existe = this.repositorioCliente.existePorId(cliente.getIdCliente());
        if(!existe) {
            throw new ExcepcionDuplicidad(CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
