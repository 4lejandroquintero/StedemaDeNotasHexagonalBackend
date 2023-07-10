package cine.boleto.consulta;

import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.dao.DaoBoleto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaBoleto {
    private final DaoBoleto daoBoleto;

    public ManejadorConsultaBoleto(DaoBoleto daoBoleto) {
        this.daoBoleto = daoBoleto;
    }

    public Boleto ejecutar(Long id){
        return daoBoleto.obtenerBoleto(id);
    }
}
