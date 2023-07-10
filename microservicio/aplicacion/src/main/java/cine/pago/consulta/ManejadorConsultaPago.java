package cine.pago.consulta;

import cine.pago.entidad.Pago;
import cine.pago.entidad.dao.DaoPago;
import cine.pago.puerto.RepositorioPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaPago {

    /*private final DaoPago daoPago;

    public ManejadorConsultaPago(DaoPago daoPago) {
        this.daoPago = daoPago;
    }

    public Pago ejecutar(Long id){
        return daoPago.obtenerPorID(id);}
*/
    private final RepositorioPago repositorioPago;

    public ManejadorConsultaPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public Pago ejecutar(Long id){
        return repositorioPago.obtener(id);
    }
}
