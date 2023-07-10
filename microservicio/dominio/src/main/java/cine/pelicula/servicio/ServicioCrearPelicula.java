package cine.pelicula.servicio;

import cine.dominio.excepcion.ExcepcionDuplicidad;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;

public class ServicioCrearPelicula {
    private static final String PELICULA_YA_EXISTE_EN_EL_SISTEMA = "La pelicula existe en el sistema";
    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }
    private void validarExistenciaPrevia(Pelicula pelicula){
        boolean existe = this.repositorioPelicula.existe(pelicula.getIdPelicula());
        if (existe){
            throw new ExcepcionDuplicidad(PELICULA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public Long ejecutar(Pelicula pelicula){
        validarExistenciaPrevia(pelicula);
        return repositorioPelicula.crear(pelicula);
    }
}
