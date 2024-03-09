package sistemaNotas.examen.comando.manejador;

import org.springframework.stereotype.Component;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.examen.comando.ComandoCrearExamen;
import sistemaNotas.examen.comando.fabrica.FabricaCrearExamen;
import sistemaNotas.examen.servicio.ServicioCrearExamen;
import sistemaNotas.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearExamen implements ManejadorComandoRespuesta<ComandoCrearExamen, ComandoRespuesta<Long>> {

  private final ServicioCrearExamen servicioCrearExamen;
  private final FabricaCrearExamen fabricaCrearExamen;

  public ManejadorCrearExamen(ServicioCrearExamen servicioCrearExamen, FabricaCrearExamen fabricaCrearExamen) {
    this.servicioCrearExamen = servicioCrearExamen;
    this.fabricaCrearExamen = fabricaCrearExamen;
  }


  @Override
  public ComandoRespuesta<Long> ejecutar(ComandoCrearExamen comandoCrearExamen) {
    return new ComandoRespuesta<>(servicioCrearExamen.ejecutar(fabricaCrearExamen.crear(comandoCrearExamen)));
  }
}
