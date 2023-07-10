package cine.factura.puerto.dao;

import cine.factura.modelo.entidad.Factura;

public interface DaoFactura {
    Factura obtener(Long id);
}
