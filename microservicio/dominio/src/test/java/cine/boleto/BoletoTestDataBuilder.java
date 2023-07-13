package cine.boleto;

import cine.boleto.entidad.Boleto;
import cine.funcion.FuncionTestDataBuilder;
import cine.funcion.modelo.entidad.Funcion;

public class BoletoTestDataBuilder {
    private Long idBoleto;
    private Integer cantidadAsientos;
    private String numeroAsientos;
    private Funcion funcion;

    public BoletoTestDataBuilder conBoletoPorDefecto() {
        this.idBoleto = 1L;
        this.cantidadAsientos = 5;
        this.numeroAsientos = "A4,A5,B4,B5,B6";
        this.funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().reconstruir();
        return this;
    }

    public BoletoTestDataBuilder conIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
        return this;
    }

    public BoletoTestDataBuilder conCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
        return this;
    }

    public BoletoTestDataBuilder conNumeroAsientos(String numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
        return this;
    }

    public BoletoTestDataBuilder conFuncion(Funcion funcion) {
        this.funcion = funcion;
        return this;
    }
    public Boleto reconstruir(){
        return Boleto.reconstruir(idBoleto,cantidadAsientos,numeroAsientos, funcion);
    }
}
