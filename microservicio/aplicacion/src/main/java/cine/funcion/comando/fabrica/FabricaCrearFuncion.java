package cine.funcion.comando.fabrica;

import cine.funcion.comando.ComandoCrearFuncion;
import cine.funcion.modelo.entidad.Funcion;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;
import org.springframework.stereotype.Component;

@Component
public class FabricaCrearFuncion {
    private final RepositorioPelicula repositorioPelicula;

    public FabricaCrearFuncion(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    private Pelicula obtenerPelicula (Long id){
        return repositorioPelicula.obtener(id);
    }

    public Funcion crear(ComandoCrearFuncion comandoCrearFuncion){
        return Funcion.crear(obtenerPelicula(comandoCrearFuncion.getIdPelicula()), comandoCrearFuncion.getNombreTeatro(),
                comandoCrearFuncion.getSalaFuncion(), comandoCrearFuncion.getDiaFuncion(), comandoCrearFuncion.getHoraFuncion(), comandoCrearFuncion.getValorFuncion(),
                comandoCrearFuncion.getCategoriaAudioFuncion(), comandoCrearFuncion.getCategoriaSubtitulosFuncion(), comandoCrearFuncion.getCategoriaVisualFuncion());
    }
}
