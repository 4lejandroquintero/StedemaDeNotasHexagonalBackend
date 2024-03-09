package sistemaNotas.pregunta;

import sistemaNotas.core.BasePrueba;
import sistemaNotas.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sistemaNotas.pregunta.entidad.Pregunta;

class PreguntaTest {
    @Test
    void deberiaCrearPreguntaExitosamente(){
        Pregunta pregunta = new PreguntaTestDataBuilder().crearPreguntaPorDefecto().reconstruir();

        Assertions.assertEquals(1L, pregunta.getPreguntaId());
        Assertions.assertEquals("Avengers: End Game", pregunta.getContenido());
        Assertions.assertEquals("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos", pregunta.getImagen());
        Assertions.assertEquals("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg", pregunta.getOpcion1());
        Assertions.assertEquals("+13", pregunta.getOpcion2());
        Assertions.assertEquals("+13", pregunta.getOpcion3());
        Assertions.assertEquals("+13", pregunta.getOpcion4());
        Assertions.assertEquals("+13", pregunta.getRespuestaDada());
        Assertions.assertEquals("+13", pregunta.getRespuesta());

    }

    @Test
    void reconstruirPreguntasinContenidoDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new PreguntaTestDataBuilder()
                        .conPreguntaId(1L)
                        .conContenido("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conImagen("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conOpcion1("+13")
                        .conOpcion2("+13")
                        .conOpcion3("+13")
                        .conOpcion4("+13")
                        .conRespuestaDada("+13")
                        .conRespuesta("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario el nombre de la pelicula");
    }

    @Test
    void reconstruirPreguntaSinIDDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new PreguntaTestDataBuilder()
                        .conContenido("Avengers: End Game")
                        .conImagen("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conOpcion1("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conOpcion2("+13")
                        .conOpcion3("+13")
                        .conOpcion4("+13")
                        .conRespuestaDada("+13")
                        .conRespuesta("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Debes ingresar el ID de la pregunta");
    }

    @Test
    void reconstruirPereguntasSinContenidoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PreguntaTestDataBuilder()
                        .conPreguntaId(1L)
                        .conContenido("Avengers: End Game")
                        .conImagen("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conOpcion1("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conOpcion2("+13")
                        .conOpcion3("+13")
                        .conOpcion4("+13")
                        .conRespuestaDada("+13")
                        .conRespuesta("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la sinopsis de la pelicula");
    }

    @Test
    void reconstruirPeliculaSinImagenDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PreguntaTestDataBuilder()
                        .conPreguntaId(1L)
                        .conContenido("Avengers: End Game")
                        .conImagen("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la imagen de la pelicula");

    }
    @Test
    void reconstruirPreguntasSinOpcionesDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PreguntaTestDataBuilder()
                        .conPreguntaId(1L)
                        .conContenido("Avengers: End Game")
                        .conImagen("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conOpcion1("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conOpcion2("+13")
                        .conOpcion3("+13")
                        .conOpcion4("+13")
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la categoria de la pelicula");
    }

   /* @Test
    void generarDTOPreguntaCorrectamente(){
        var preguntaDTO = new PreguntaTestDataBuilder().crearPreguntaPorDefecto().crearDTO();

        Assertions.assertEquals(1L, preguntaDTO.getIdPelicula());
        Assertions.assertEquals("Avengers: End Game", preguntaDTO.getNombrePelicula());
        Assertions.assertEquals("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos",
                preguntaDTO.getSinopsisPelicula());
        Assertions.assertEquals("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg",
                preguntaDTO.getImagenPortada());
        Assertions.assertEquals("+13", preguntaDTO.getCategoriaEdadPelicula());
    }

*/
}
