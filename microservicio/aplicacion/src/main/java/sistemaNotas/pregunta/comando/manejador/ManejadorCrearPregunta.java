package sistemaNotas.pregunta.comando.manejador;

import org.springframework.stereotype.Component;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.manejador.ManejadorComandoRespuesta;
import sistemaNotas.pregunta.comando.ComandoCrearPregunta;
import sistemaNotas.pregunta.comando.fabrica.FabricaCrearPregunta;
import sistemaNotas.pregunta.servicio.ServicioCrearPregunta;

@Component
public class ManejadorCrearPregunta implements ManejadorComandoRespuesta<ComandoCrearPregunta, ComandoRespuesta<Long>> {

  private final FabricaCrearPregunta fabricaCrearPregunta;
  private final ServicioCrearPregunta servicioCrearPregunta;

  public ManejadorCrearPregunta(FabricaCrearPregunta fabricaCrearPregunta, ServicioCrearPregunta servicioCrearPregunta) {
    this.fabricaCrearPregunta = fabricaCrearPregunta;
    this.servicioCrearPregunta = servicioCrearPregunta;
  }


  @Override
  public ComandoRespuesta<Long> ejecutar(ComandoCrearPregunta comandoCrearPregunta) {
    return new ComandoRespuesta<>(servicioCrearPregunta.ejecutar(fabricaCrearPregunta.crear(comandoCrearPregunta)));
  }
}
