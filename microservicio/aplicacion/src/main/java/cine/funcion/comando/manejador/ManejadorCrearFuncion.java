package cine.funcion.comando.manejador;

import cine.ComandoRespuesta;
import cine.funcion.comando.ComandoCrearFuncion;
import cine.funcion.comando.fabrica.FabricaCrearFuncion;
import cine.funcion.servicio.ServicioCrearFuncion;
import cine.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFuncion implements ManejadorComandoRespuesta<ComandoCrearFuncion, ComandoRespuesta<Long>> {

    private final ServicioCrearFuncion servicioCrearFuncion;
    private final FabricaCrearFuncion fabricaCrearFuncion;

    public ManejadorCrearFuncion(ServicioCrearFuncion servicioCrearFuncion, FabricaCrearFuncion fabricaCrearFuncion) {
        this.servicioCrearFuncion = servicioCrearFuncion;
        this.fabricaCrearFuncion = fabricaCrearFuncion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCrearFuncion comandoCrearFuncion) {
        return new ComandoRespuesta<>(servicioCrearFuncion.ejecutar(fabricaCrearFuncion.crear(comandoCrearFuncion)));
    }
}
