package cine.factura.comando.manejador;

import cine.factura.comando.ComandoAnular;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.factura.servicio.ServicioAnular;
import cine.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAnular implements ManejadorComando<ComandoAnular> {
    private final ServicioAnular servicioAnular;
    private final RepositorioFactura repositorioFactura;

    public ManejadorAnular(ServicioAnular servicioAnular, RepositorioFactura repositorioFactura) {
        this.servicioAnular = servicioAnular;
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public void ejecutar(ComandoAnular comandoAnular) {
        servicioAnular.ejecutar(repositorioFactura.obtener(comandoAnular.getIdFactura()));

    }
}
