package cine.factura.puerto.dao;

import cine.factura.modelo.dto.ResumenFacturaDTO;
import cine.factura.modelo.entidad.Factura;

public interface DaoFactura {
    ResumenFacturaDTO obtener(Long id);
}
