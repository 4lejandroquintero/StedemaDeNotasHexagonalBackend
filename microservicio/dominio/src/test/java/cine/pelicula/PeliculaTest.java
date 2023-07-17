package cine.pelicula;

import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
import cine.pelicula.entidad.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeliculaTest {
    @Test
    void deberiaCrearPeliculaExitosamente(){
        Pelicula pelicula = new PeliculaTestDataBuilder().crearPeliculaPorDefecto().reconstruir();

        Assertions.assertEquals(1L, pelicula.getIdPelicula());
        Assertions.assertEquals("Avengers: End Game", pelicula.getNombrePelicula());
        Assertions.assertEquals("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos", pelicula.getSinopsisPelicula());
        Assertions.assertEquals("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg", pelicula.getImagenPortada());
        Assertions.assertEquals("+13", pelicula.getCategoriaEdadPelicula());

    }

    @Test
    void reconstruirPeliculasinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new PeliculaTestDataBuilder()
                        .conID(1L)
                        .conSinopsis("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conImagenPortada("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conCategoriaEdadPelicula("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario el nombre de la pelicula");
    }

    @Test
    void reconstruirPeliculaSinIDDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new PeliculaTestDataBuilder()
                        .conNombre("Avengers: End Game")
                        .conSinopsis("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conImagenPortada("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conCategoriaEdadPelicula("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Debes ingresar el ID de la pelicula");
    }

    @Test
    void reconstruirPeliculasSinSinopsisDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PeliculaTestDataBuilder()
                        .conID(1L)
                        .conNombre("Avengers: End Game")
                        .conImagenPortada("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .conCategoriaEdadPelicula("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la sinopsis de la pelicula");
    }

    @Test
    void reconstruirPeliculaSinImagenDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PeliculaTestDataBuilder()
                        .conID(1L)
                        .conNombre("Avengers: End Game")
                        .conSinopsis("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conCategoriaEdadPelicula("+13").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la portada de la pelicula");

    }
    @Test
    void reconstruirPeliculaSinCategoriaEdadDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PeliculaTestDataBuilder()
                        .conID(1L)
                        .conNombre("Avengers: End Game")
                        .conSinopsis("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos")
                        .conImagenPortada("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg")
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar la categoria de la pelicula");
    }

    @Test
    void generarDTOPeliculaCorrectamente(){
        var peliculaDTO = new PeliculaTestDataBuilder().crearPeliculaPorDefecto().crearDTO();

        Assertions.assertEquals(1L, peliculaDTO.getIdPelicula());
        Assertions.assertEquals("Avengers: End Game", peliculaDTO.getNombrePelicula());
        Assertions.assertEquals("Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos",
                peliculaDTO.getSinopsisPelicula());
        Assertions.assertEquals("https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg",
                peliculaDTO.getImagenPortada());
        Assertions.assertEquals("+13", peliculaDTO.getCategoriaEdadPelicula());
    }


}
