package sistemaNotas.pregunta.comando.manejador;

import org.springframework.stereotype.Component;
import sistemaNotas.ComandoRespuesta;
import sistemaNotas.manejador.ManejadorComandoRespuesta;
import sistemaNotas.pregunta.comando.ComandoSolicitudCrearPregunta;
import sistemaNotas.pregunta.comando.fabrica.GeneradorPregunta;
import sistemaNotas.pregunta.servicio.ServicioCrearPregunta;

@Component
public class ManejadorCrearPregunta implements ManejadorComandoRespuesta<ComandoSolicitudCrearPregunta, ComandoRespuesta<Long>> {

  private final GeneradorPregunta generadorPregunta;
  private final ServicioCrearPregunta servicioCrearPregunta;

  public ManejadorCrearPregunta(GeneradorPregunta generadorPregunta, ServicioCrearPregunta servicioCrearPregunta) {
    this.generadorPregunta = generadorPregunta;
    this.servicioCrearPregunta = servicioCrearPregunta;
  }


  @Override
  public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearPregunta comandoSolicitudCrearPregunta) {
    return new ComandoRespuesta<>(servicioCrearPregunta.ejecutar(generadorPregunta.crear(comandoSolicitudCrearPregunta)));
  }
}
