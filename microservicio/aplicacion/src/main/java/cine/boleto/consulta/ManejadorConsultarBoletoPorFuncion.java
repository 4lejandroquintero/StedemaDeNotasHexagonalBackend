package cine.boleto.consulta;

import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.dao.DaoBoleto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarBoletoPorFuncion {
    private final DaoBoleto daoBoleto;

    public ManejadorConsultarBoletoPorFuncion(DaoBoleto daoBoleto) {
        this.daoBoleto = daoBoleto;
    }

    public List<Boleto> ejecutar(Long id){
        return daoBoleto.obtenerBoletosDeFuncion(id);
    }
}
