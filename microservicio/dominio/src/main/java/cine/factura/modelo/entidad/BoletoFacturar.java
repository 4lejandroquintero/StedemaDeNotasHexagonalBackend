package cine.factura.modelo.entidad;

import cine.boleto.entidad.Boleto;
import cine.dominio.ValidadorArgumento;

public class BoletoFacturar {
    private Long idBoleto;
    private Integer cantidad;
    private Boleto boleto;

    private BoletoFacturar(Integer cantidad, Boleto boleto) {
        this.cantidad = cantidad;
        this.boleto = boleto;
    }
    private BoletoFacturar(Long idBoleto, Integer cantidad, Boleto boleto) {
        this.idBoleto = idBoleto;
        this.cantidad = cantidad;
        this.boleto = boleto;
    }
    public static BoletoFacturar crear(Integer cantidad, Boleto boleto){
        ValidadorArgumento.validarObligatorio(cantidad, "Ingresa el numero de boletos a comprar");
        ValidadorArgumento.validarObligatorio(boleto, "Debes agregar un boleto");
        return new BoletoFacturar(cantidad, boleto);
    }
}
