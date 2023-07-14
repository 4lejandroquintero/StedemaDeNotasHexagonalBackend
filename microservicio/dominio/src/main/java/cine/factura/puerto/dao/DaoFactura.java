package cine.factura.puerto.dao;

import cine.factura.modelo.dto.ResumenFacturaDTO;

public interface DaoFactura {
    ResumenFacturaDTO obtener(Long id);
}
