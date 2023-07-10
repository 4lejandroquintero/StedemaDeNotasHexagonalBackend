package cine.boleto.servicio;

import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.RepositorioBoleto;

public class ServicioCrearBoleto {
    private final RepositorioBoleto repositorioBoleto;

    public ServicioCrearBoleto(RepositorioBoleto repositorioBoleto) {
        this.repositorioBoleto = repositorioBoleto;
    }

    public Long ejecutar(Boleto boleto){
        return this.repositorioBoleto.crear(boleto);
    }
}
