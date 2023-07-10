package cine.factura.consulta;

import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaFactura {
    private final DaoFactura daoFactura;

    public ManejadorConsultaFactura(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }
    public Factura obtenerFactura(Long id){
        return daoFactura.obtener(id);
    }
}
