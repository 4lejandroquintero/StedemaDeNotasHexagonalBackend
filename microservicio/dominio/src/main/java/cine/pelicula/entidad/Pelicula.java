package cine.pelicula.entidad;

import cine.dominio.ValidadorArgumento;

public class Pelicula {
    private final Long idPelicula;
    private final String nombrePelicula;
    private final String sinopsisPelicula;
    private final String imagenPortada;
    private final String categoriaEdadPelicula;

    public Pelicula(Long idPelicula, String nombrePelicula, String sinopsisPelicula, String imagenPortada, String categoriaEdadPelicula) {
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.imagenPortada = imagenPortada;
        this.categoriaEdadPelicula = categoriaEdadPelicula;
    }
    public static Pelicula reconstruir(Long idPelicula, String nombrePelicula, String sinopsisPelicula, String imagenPortada, String categoriaEdadPelicula){
        ValidadorArgumento.validarObligatorio(idPelicula, "Debes ingresar el ID de la pelicula");
        ValidadorArgumento.validarObligatorio(nombrePelicula, "Es necesario el nombre de la pelicula");
        ValidadorArgumento.validarObligatorio(sinopsisPelicula, "Es necesario ingresar la sinopsis de la pelicula");
        ValidadorArgumento.validarObligatorio(imagenPortada, "Es necesario ingresar la portada de la pelicula");
        ValidadorArgumento.validarObligatorio(categoriaEdadPelicula, "Es necesario ingresar la categoria de la pelicula");
        return new Pelicula(idPelicula, nombrePelicula, sinopsisPelicula, imagenPortada, categoriaEdadPelicula);
    }
    public Long getIdPelicula() {
        return idPelicula;
    }
    public String getNombrePelicula() {
        return nombrePelicula;
    }
    public String getSinopsisPelicula() {
        return sinopsisPelicula;
    }
    public String getImagenPortada() {
        return imagenPortada;
    }
    public String getCategoriaEdadPelicula() {
        return categoriaEdadPelicula;
    }
}
