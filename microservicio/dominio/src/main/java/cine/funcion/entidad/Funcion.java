package cine.funcion.entidad;

import cine.dominio.ValidadorArgumento;

import java.time.LocalDate;
import java.time.LocalTime;


public class Funcion {
    private Long idFuncion;
    private String nombreTeatro;
    private String nombrePelicula;
    private String salaFuncion;
    private LocalDate diaFuncion;
    private LocalTime horaFuncion;
    private Integer valorFuncion;

    public Funcion(Long idFuncion, String nombreTeatro, String nombrePelicula, String salaFuncion, LocalDate diaFuncion, LocalTime horaFuncion, Integer valorFuncion) {
        this.idFuncion = idFuncion;
        this.nombreTeatro = nombreTeatro;
        this.nombrePelicula = nombrePelicula;
        this.salaFuncion = salaFuncion;
        this.diaFuncion = diaFuncion;
        this.horaFuncion = horaFuncion;
        this.valorFuncion = valorFuncion;
    }

    public static Funcion reconstruir(Long idFuncion, String nombreTeatro, String nombrePelicula, String salaFuncion, LocalDate diaFuncion,LocalTime horaFuncion, Integer valorFuncion){
        ValidadorArgumento.validarObligatorio(idFuncion,"El id de la función es requerido");
        ValidadorArgumento.validarObligatorio(nombreTeatro,"El nombre del teatro es requerido");
        ValidadorArgumento.validarObligatorio(nombrePelicula,"El nombre de la pelicula es requerido");
        ValidadorArgumento.validarObligatorio(salaFuncion,"La sala de la funcion es requerida");
        ValidadorArgumento.validarObligatorio(diaFuncion,"El dia de la función es requerido");
        ValidadorArgumento.validarObligatorio(horaFuncion,"La hora de la función es requerido");
        ValidadorArgumento.validarObligatorio(valorFuncion,"El valor de la funcion es requerido");
        return new Funcion(idFuncion, nombreTeatro, nombrePelicula, salaFuncion, diaFuncion, horaFuncion, valorFuncion);
    }

    public Long getIdFuncion() {
        return idFuncion;
    }

    public String getNombreTeatro() {
        return nombreTeatro;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getSalaFuncion() {
        return salaFuncion;
    }

    public LocalDate getDiaFuncion() {
        return diaFuncion;
    }

    public LocalTime getHoraFuncion() {
        return horaFuncion;
    }

    public Integer getValorFuncion() {
        return valorFuncion;
    }
}
