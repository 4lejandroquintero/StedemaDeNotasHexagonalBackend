package sistemaNotas.categoria.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.categoria.comando.ComandoSolicitudCrearCategoria;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;

@Component
public class GenerarSolicitudCrearCategoria {

  //Transformamos el objeto de domnio a un objeto de codigo

  private final ExamenRepositorio examenRepositorio;

  public GenerarSolicitudCrearCategoria(ExamenRepositorio examenRepositorio) {
    this.examenRepositorio = examenRepositorio;
  }


  private Examen obtenerExamen(Long id){
    return examenRepositorio.obtener(id);
  }

  public Categoria crear(ComandoSolicitudCrearCategoria comandoSolicitudCrearCategoria){
    return Categoria.crear(comandoSolicitudCrearCategoria.getTitulo(),
      comandoSolicitudCrearCategoria.getDescripcion(), obtenerExamen(comandoSolicitudCrearCategoria.getExamenId()));
  }
}
