package cine.funcion;

import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
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
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().conPelicula(pelicula).crear();

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
    @Test
    void crearFuncionSinPeliculaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conPelicula(null).crear(),
                ExcepcionValorObligatorio.class, "La pelicula es requerido para crear una funcion");
    }
    @Test
    void crearFuncionSinNombreTeatroDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conNombreTeatro(null).crear(),
                ExcepcionValorObligatorio.class, "El nombre del teatro es requerido");
    }
    @Test
    void crearFuncionSinSalaFuncionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conSalaFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "La sala de la funcion es requerida");
    }
    @Test
    void crearFuncionSinDiaFuncionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conDiaFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "El dia de la función es requerido");
    }@Test
    void crearFuncionSinHoraDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conHoraFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "La hora de la función es requerido");
    }
    @Test
    void crearFuncionSinValorDeCostoDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conValorFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "El valor de la funcion es requerido");
    }
    @Test
    void crearFuncionSinEspecificacionAudioDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaAudioFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "Dato del audio es requerido");
    }
    @Test
    void crearFuncionSinSubtitulosDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaSubtitulosFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "Dato de los subtitulos es requerido");
    }
    @Test
    void crearFuncionSinEspecificacionCategoriaVisualDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaVisualFuncion(null).crear(),
                ExcepcionValorObligatorio.class, "Dato de tipo de categoria visual es requerido");
    }

    @Test
    void deberiaReconstruirFuncionCorrectamente(){
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
    @Test
    void reconstruirFuncionSinIDPeliculaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conIdFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El id de la función es requerido");
    }
    @Test
    void reconstruirFuncionSinPeliculaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conPelicula(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Es necesario ingresar la pelicula es requerido");
    }
    @Test
    void reconstruirFuncionSinNombreTeatroDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conNombreTeatro(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El nombre del teatro es requerido");
    }
    @Test
    void reconstruirFuncionSinSalaFuncionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conSalaFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "La sala de la funcion es requerida");
    }
    @Test
    void reconstruirFuncionSinDiaFuncionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conDiaFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El dia de la función es requerido");
    }@Test
    void reconstruirFuncionSinHoraDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conHoraFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "La hora de la función es requerido");
    }
    @Test
    void reconstruirFuncionSinValorDeCostoDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conValorFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El valor de la funcion es requerido");
    }
    @Test
    void reconstruirFuncionSinEspecificacionAudioDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaAudioFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Dato del audio es requerido");
    }
    @Test
    void reconstruirFuncionSinSubtitulosDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaSubtitulosFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Dato de los subtitulos es requerido");
    }
    @Test
    void reconstruirFuncionSinEspecificacionCategoriaVisualDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new FuncionTestDataBuilder().crearFuncionPorDefecto().conCategoriaVisualFuncion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Dato de tipo de categoria visual es requerido");
    }
}
