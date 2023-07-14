package cine.factura.comando.manejador;

import cine.factura.comando.ComandoPagar;
import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.factura.servicio.ServicioFacturaPagada;
import cine.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFacturaPagada implements ManejadorComando<ComandoPagar> {
    private final ServicioFacturaPagada servicioFacturaPagada;
    private final RepositorioFactura repositorioFactura;

    public ManejadorFacturaPagada(ServicioFacturaPagada servicioFacturaPagada, RepositorioFactura repositorioFactura) {
        this.servicioFacturaPagada = servicioFacturaPagada;
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public void ejecutar(ComandoPagar comandoPagar) {
        servicioFacturaPagada.ejecutar(repositorioFactura.obtener(comandoPagar.getIdFactura()));
    }
}
