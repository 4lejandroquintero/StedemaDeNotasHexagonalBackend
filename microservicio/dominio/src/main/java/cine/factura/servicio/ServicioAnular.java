package cine.factura.servicio;

import cine.dominio.ValidadorArgumento;
import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.repositorio.RepositorioFactura;

public class ServicioAnular {
    private final RepositorioFactura repositorioFactura;

    public ServicioAnular(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura){
        ValidadorArgumento.validarObligatorio(factura, "No existe una factura para anular");
        factura.anularFactura();
        repositorioFactura.actualizarEstado(factura);
    }
}
