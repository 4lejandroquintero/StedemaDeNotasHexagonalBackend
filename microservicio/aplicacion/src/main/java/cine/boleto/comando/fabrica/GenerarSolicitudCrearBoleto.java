package cine.boleto.comando.fabrica;

import cine.boleto.comando.ComandoSolicitudCrearBoleto;
import cine.boleto.entidad.Boleto;
import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.RepositorioFuncion;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearBoleto {

    //Transformamos el objeto de domnio a un objeto de codigo

    private final RepositorioFuncion repositorioFuncion;

    public GenerarSolicitudCrearBoleto(RepositorioFuncion repositorioFuncion) {
        this.repositorioFuncion = repositorioFuncion;
    }

    private Funcion obtenerFuncion(Long id){
        return repositorioFuncion.obtener(id);
    }

    public Boleto crear(ComandoSolicitudCrearBoleto comandoSolicitudCrearBoleto){
        return Boleto.reconstruir(comandoSolicitudCrearBoleto.getIdBoleto(), comandoSolicitudCrearBoleto.getCantidadAsientos(),
                comandoSolicitudCrearBoleto.getNumeroAsientos(), repositorioFuncion.obtener(comandoSolicitudCrearBoleto.getIdFuncion()));
    }
}
