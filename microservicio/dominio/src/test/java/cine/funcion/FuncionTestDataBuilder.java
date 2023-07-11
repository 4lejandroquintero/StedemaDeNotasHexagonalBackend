package cine.funcion;

import cine.funcion.modelo.entidad.Funcion;
import cine.pelicula.PeliculaTestDataBuilder;
import cine.pelicula.entidad.Pelicula;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FuncionTestDataBuilder {
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

    public FuncionTestDataBuilder crearFuncionPorDefecto() {
        this.idFuncion = 1L;
        this.pelicula = new PeliculaTestDataBuilder().crearPeliculaPorDefecto().reconstruir();
        this.nombreTeatro = "Cinemark";
        this.salaFuncion = "01";
        this.diaFuncion = LocalDate.of(2023,3,12);
        this.horaFuncion = LocalTime.of(5,20);
        this.valorFuncion = BigDecimal.valueOf(22000);
        this.categoriaAudioFuncion = "Doblaje Latino";
        this.categoriaSubtitulosFuncion = "Sin Subtitulos";
        this.categoriaVisualFuncion = "2D";
        return this;
    }

    public FuncionTestDataBuilder conIdFuncion(Long idFuncion) {
        this.idFuncion = idFuncion;
        return this;
    }

    public FuncionTestDataBuilder conPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        return this;
    }

    public FuncionTestDataBuilder conNombreTeatro(String nombreTeatro) {
        this.nombreTeatro = nombreTeatro;
        return this;
    }

    public FuncionTestDataBuilder conSalaFuncion(String salaFuncion) {
        this.salaFuncion = salaFuncion;
        return this;
    }

    public FuncionTestDataBuilder conDiaFuncion(LocalDate diaFuncion) {
        this.diaFuncion = diaFuncion;
        return this;
    }

    public FuncionTestDataBuilder conHoraFuncion(LocalTime horaFuncion) {
        this.horaFuncion = horaFuncion;
        return this;
    }

    public FuncionTestDataBuilder conValorFuncion(BigDecimal valorFuncion) {
        this.valorFuncion = valorFuncion;
        return this;
    }

    public FuncionTestDataBuilder conCategoriaAudioFuncion(String categoriaAudioFuncion) {
        this.categoriaAudioFuncion = categoriaAudioFuncion;
        return this;
    }

    public FuncionTestDataBuilder conCategoriaSubtitulosFuncion(String categoriaSubtitulosFuncion) {
        this.categoriaSubtitulosFuncion = categoriaSubtitulosFuncion;
        return this;
    }

    public FuncionTestDataBuilder conCategoriaVisualFuncion(String categoriaVisualFuncion) {
        this.categoriaVisualFuncion = categoriaVisualFuncion;
        return this;
    }
    public Funcion reconstruir(){
        return Funcion.reconstruir(idFuncion, pelicula, nombreTeatro, salaFuncion, diaFuncion, horaFuncion, valorFuncion, categoriaAudioFuncion, categoriaSubtitulosFuncion, categoriaVisualFuncion);
    }
}
