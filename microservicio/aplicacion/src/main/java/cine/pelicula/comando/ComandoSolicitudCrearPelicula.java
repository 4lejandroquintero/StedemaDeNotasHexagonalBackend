package cine.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearPelicula {
    private Long idPelicula;
    private String nombrePelicula;
    private String sinopsisPelicula;
    private String imagenPortada;
    private String categoriaEdadPelicula;
}
