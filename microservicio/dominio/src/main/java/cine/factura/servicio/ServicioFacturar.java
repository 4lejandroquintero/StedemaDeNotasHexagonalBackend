package cine.factura.servicio;

import cine.factura.modelo.entidad.Factura;
import cine.factura.modelo.entidad.SolicitudFacturar;
import cine.factura.puerto.repositorio.RepositorioFactura;

public class ServicioFacturar {
    private final RepositorioFactura repositorioFactura;

    public ServicioFacturar(RepositorioFactura repositorioFactura){
        this.repositorioFactura = repositorioFactura;
    }
    public Long ejecutar(SolicitudFacturar solicitudFacturar){
        Factura factura = Factura.crear(solicitudFacturar);
        return repositorioFactura.guardar(factura);
    }
}
