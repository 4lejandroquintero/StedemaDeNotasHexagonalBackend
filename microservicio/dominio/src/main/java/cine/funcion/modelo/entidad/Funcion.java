package cine.funcion.modelo.entidad;

import cine.dominio.ValidadorArgumento;
import cine.pelicula.entidad.Pelicula;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public class Funcion {
    private Long idFuncion;
    private Pelicula pelicula;
    private String nombreTeatro;
    private String salaFuncion;
    private LocalDate diaFuncion;
    private LocalTime horaFuncion;
    private BigDecimal valorFuncion;
    private String categoriaAudioFuncion;
    private String categoriaSubtitulosFuncion;
    private String categoriaVisualFuncion;

    public Funcion(Long idFuncion, Pelicula pelicula, String nombreTeatro, String salaFuncion, LocalDate diaFuncion,
                   LocalTime horaFuncion, BigDecimal valorFuncion, String categoriaAudioFuncion,String categoriaSubtitulosFuncion,
                   String categoriaVisualFuncion) {
        this.idFuncion = idFuncion;
        this.pelicula = pelicula;
        this.nombreTeatro = nombreTeatro;
        this.salaFuncion = salaFuncion;
        this.diaFuncion = diaFuncion;
        this.horaFuncion = horaFuncion;
        this.valorFuncion = valorFuncion;
        this.categoriaAudioFuncion = categoriaAudioFuncion;
        this.categoriaSubtitulosFuncion = categoriaSubtitulosFuncion;
        this.categoriaVisualFuncion = categoriaVisualFuncion;
    }

    public static Funcion reconstruir(Long idFuncion, Pelicula pelicula, String nombreTeatro, String salaFuncion, LocalDate diaFuncion, LocalTime horaFuncion, BigDecimal valorFuncion,
                                      String categoriaAudioFuncion,String categoriaSubtitulosFuncion,
                                      String categoriaVisualFuncion){
        ValidadorArgumento.validarObligatorio(idFuncion,"El id de la función es requerido");
        ValidadorArgumento.validarObligatorio(nombreTeatro,"El nombre del teatro es requerido");
        ValidadorArgumento.validarObligatorio(pelicula,"El nombre de la pelicula es requerido");
        ValidadorArgumento.validarObligatorio(salaFuncion,"La sala de la funcion es requerida");
        ValidadorArgumento.validarObligatorio(diaFuncion,"El dia de la función es requerido");
        ValidadorArgumento.validarObligatorio(horaFuncion,"La hora de la función es requerido");
        ValidadorArgumento.validarObligatorio(valorFuncion,"El valor de la funcion es requerido");
        ValidadorArgumento.validarObligatorio(categoriaAudioFuncion,"Dato del audio es requerido");
        ValidadorArgumento.validarObligatorio(categoriaSubtitulosFuncion,"Dato de los subtitulos es requerido");
        ValidadorArgumento.validarObligatorio(categoriaVisualFuncion,"Dato de tipo de categoria visual es requerido");

        return new Funcion( idFuncion,  pelicula,  nombreTeatro,  salaFuncion,  diaFuncion,  horaFuncion,  valorFuncion, categoriaAudioFuncion, categoriaSubtitulosFuncion, categoriaVisualFuncion);
    }

    public Long getIdFuncion() {
        return idFuncion;
    }

    public String getNombreTeatro() {
        return nombreTeatro;
    }

    public Pelicula getPelicula() {
        return pelicula;
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

    public BigDecimal getValorFuncion() {
        return valorFuncion;
    }

    public String getCategoriaAudioFuncion() {
        return categoriaAudioFuncion;
    }

    public void setCategoriaAudioFuncion(String categoriaAudioFuncion) {
        this.categoriaAudioFuncion = categoriaAudioFuncion;
    }

    public String getCategoriaSubtitulosFuncion() {
        return categoriaSubtitulosFuncion;
    }

    public void setCategoriaSubtitulosFuncion(String categoriaSubtitulosFuncion) {
        this.categoriaSubtitulosFuncion = categoriaSubtitulosFuncion;
    }

    public String getCategoriaVisualFuncion() {
        return categoriaVisualFuncion;
    }

    public void setCategoriaVisualFuncion(String categoriaVisualFuncion) {
        this.categoriaVisualFuncion = categoriaVisualFuncion;
    }
}
