package cine.boleto.entidad;

import cine.dominio.ValidadorArgumento;
import cine.funcion.modelo.entidad.Funcion;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {
    private final Long idBoleto;
    private final Integer cantidadAsientos;
    private final String numeroAsientos;
    private final Funcion funcion;

    public Boleto(Long idBoleto,Integer cantidadAsientos, String numeroAsientos , Funcion funcion) {
        this.idBoleto = idBoleto;
        this.cantidadAsientos = cantidadAsientos;
        this.numeroAsientos = numeroAsientos;
        this.funcion = funcion;
    }

    public static Boleto reconstruir(Long idBoleto, Integer cantidadAsientos, String numeroAsientos, Funcion funcion){
        ValidadorArgumento.validarObligatorio(idBoleto, "El id del boleto debe ser ingresado");
        ValidadorArgumento.validarObligatorio(cantidadAsientos, "Debe ingresar la cantidad de asientos");
        ValidadorArgumento.validarObligatorio(numeroAsientos, "El boleto debe de contar con un numero de asiento");
        ValidadorArgumento.validarObligatorio(funcion, "Debe tener una función dada para el boleto");
        return new Boleto(idBoleto, cantidadAsientos, numeroAsientos, funcion);
    }

    public  BigDecimal obtenerValorFuncion(){
        return this.funcion.getValorFuncion();
    }
    public LocalDate obtenerFechaFuncion(){
        return this.funcion.getDiaFuncion();
    }
    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }
    public Long getIdBoleto() {
        return idBoleto;
    }
    public Funcion getFuncion() {
        return funcion;
    }
    public String getNumeroAsientos() {
        return numeroAsientos;
    }
}
