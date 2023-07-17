package cine.pelicula.comando;

public class ComandoControladorPeliculaTestDataBuilder {
    private Long idPelicula;
    private String nombrePelicula;
    private String sinopsisPelicula;
    private String imagenPortada;
    private String categoriaEdadPelicula;

    public ComandoControladorPeliculaTestDataBuilder conPeliculaPorDefecto() {
        this.idPelicula = 2L;
        this.nombrePelicula = "Ant Man";
        this.sinopsisPelicula = "Pelicula de Superheroes";
        this.imagenPortada = "urlImagen";
        this.categoriaEdadPelicula = "+12";
        return this;
    }
    public ComandoSolicitudCrearPelicula construir (){
        return new ComandoSolicitudCrearPelicula(idPelicula,nombrePelicula,sinopsisPelicula,imagenPortada,categoriaEdadPelicula);
    }
}
