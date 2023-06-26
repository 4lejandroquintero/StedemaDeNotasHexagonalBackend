package cine.boleto.entidad;

import cine.dominio.ValidadorArgumento;
import cine.funcion.entidad.Funcion;

public class Boleto {
    private Long idBoleto;
    private Funcion funcion;
    private String numeroAsiento;

    public Boleto(Long idBoleto, Funcion funcion, String numeroAsiento) {
        this.idBoleto = idBoleto;
        this.funcion = funcion;
        this.numeroAsiento = numeroAsiento;
    }

    public static Boleto reconstruir(Long idBoleto, Funcion funcion, String numeroAsiento){
        ValidadorArgumento.validarObligatorio(idBoleto, "El id del boleto debe ser ingresado");
        ValidadorArgumento.validarObligatorio(funcion, "Debe tener una función dada para el boelto");
        ValidadorArgumento.validarObligatorio(numeroAsiento, "El boleto debe de contar con un numero de asiento");
        return new Boleto(idBoleto, funcion, numeroAsiento);
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }
}
