package cine.factura.puerto.repositorio;

import cine.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
    Long guardar(Factura factura);
    Factura obtener(Long idFactura);
    void actualizarEstado(Factura factura);
}
