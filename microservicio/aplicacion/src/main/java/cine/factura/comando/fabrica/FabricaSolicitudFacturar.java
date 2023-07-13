package cine.factura.comando.fabrica;

import cine.boleto.puerto.RepositorioBoleto;
import cine.cliente.puerto.RepositorioCliente;
import cine.factura.comando.ComandoSolicitudFacturar;
import cine.factura.modelo.entidad.SolicitudFacturar;
import org.springframework.stereotype.Component;


@Component
public class FabricaSolicitudFacturar {
    private final RepositorioBoleto repositorioBoleto;
    private final RepositorioCliente repositorioCliente;

    public FabricaSolicitudFacturar(RepositorioBoleto repositorioBoleto, RepositorioCliente repositorioCliente) {
        this.repositorioBoleto = repositorioBoleto;
        this.repositorioCliente = repositorioCliente;
    }

    public SolicitudFacturar crear(ComandoSolicitudFacturar comandoSolicitudFacturar){
        return new SolicitudFacturar(repositorioCliente.obtener(comandoSolicitudFacturar.getIdCliente()),repositorioBoleto.obtener(comandoSolicitudFacturar.getIdBoleto()));
    }


}
