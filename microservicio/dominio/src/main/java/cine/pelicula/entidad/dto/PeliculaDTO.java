package cine.pelicula.entidad.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PeliculaDTO {
    private Long idPelicula;
    private String nombrePelicula;
    private String sinopsisPelicula;
    private String imagenPortada;
    private String categoriaEdadPelicula;
}
