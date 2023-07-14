package cine.factura.servicio;

import cine.dominio.ValidadorArgumento;
import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.repositorio.RepositorioFactura;

public class ServicioFacturaPagada {
    private final RepositorioFactura repositorioFactura;

    public ServicioFacturaPagada(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura){
        ValidadorArgumento.validarObligatorio(factura, "No existe una factura para pagar");
        factura.facturaPagada();
        repositorioFactura.actualizarEstado(factura);
    }
}
