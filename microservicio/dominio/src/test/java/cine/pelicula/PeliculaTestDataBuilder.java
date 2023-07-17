package cine.pelicula;

import cine.pelicula.entidad.Pelicula;
import cine.pelicula.entidad.dto.PeliculaDTO;

public class PeliculaTestDataBuilder {
    private Long idPelicula;
    private String nombrePelicula;
    private String sinopsisPelicula;
    private String imagenPortada;
    private String categoriaEdadPelicula;

    public PeliculaTestDataBuilder crearPeliculaPorDefecto() {
        this.idPelicula = 1L;
        this.nombrePelicula = "Avengers: End Game";
        this.sinopsisPelicula = "Después de los eventos de Infinity War, el universo está en ruinas debido a las acciones de Thanos";
        this.imagenPortada = "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2019/4/w1280/br6krBFpaYmCSglLBWRuhui7tPc.jpg";
        this.categoriaEdadPelicula = "+13";
        return this;
    }

    public PeliculaTestDataBuilder conID(Long idPelicula) {
        this.idPelicula = idPelicula;
        return this;
    }

    public PeliculaTestDataBuilder conNombre(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
        return this;
    }

    public PeliculaTestDataBuilder conSinopsis(String sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
        return this;
    }

    public PeliculaTestDataBuilder conImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
        return this;
    }

    public PeliculaTestDataBuilder conCategoriaEdadPelicula(String categoriaEdadPelicula) {
        this.categoriaEdadPelicula = categoriaEdadPelicula;
        return this;
    }

    public Pelicula reconstruir(){
        return Pelicula.reconstruir(idPelicula,nombrePelicula,sinopsisPelicula,imagenPortada,categoriaEdadPelicula);
    }

    public PeliculaDTO crearDTO(){
        return new PeliculaDTO(idPelicula,nombrePelicula,sinopsisPelicula,imagenPortada,categoriaEdadPelicula);
    }

}
