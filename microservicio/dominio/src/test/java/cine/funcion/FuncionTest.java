package cine.funcion;

import cine.funcion.modelo.entidad.Funcion;
import cine.pelicula.PeliculaTestDataBuilder;
import cine.pelicula.entidad.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

class FuncionTest {
    @Test
    void deberiaCrearFuncionCorrectamente(){
        Pelicula pelicula = new PeliculaTestDataBuilder().crearPeliculaPorDefecto().reconstruir();
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().conPelicula(pelicula).reconstruir();

        Assertions.assertEquals(1L, funcion.getIdFuncion());
        Assertions.assertEquals(pelicula, funcion.getPelicula());
        Assertions.assertEquals("Cinemark", funcion.getNombreTeatro());
        Assertions.assertEquals("01", funcion.getSalaFuncion());
        Assertions.assertEquals(LocalDate.of(2023,3,12), funcion.getDiaFuncion());
        Assertions.assertEquals(LocalTime.of(5,20), funcion.getHoraFuncion());
        Assertions.assertEquals(BigDecimal.valueOf(22000), funcion.getValorFuncion());
        Assertions.assertEquals("Doblaje Latino", funcion.getCategoriaAudioFuncion());
        Assertions.assertEquals("Sin Subtitulos", funcion.getCategoriaSubtitulosFuncion());
        Assertions.assertEquals("2D", funcion.getCategoriaVisualFuncion());
    }
}
