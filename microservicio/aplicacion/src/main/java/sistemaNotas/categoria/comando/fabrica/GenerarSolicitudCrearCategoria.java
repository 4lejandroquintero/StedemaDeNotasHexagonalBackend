package sistemaNotas.categoria.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.categoria.comando.ComandoSolicitudCrearCategoria;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;

@Component
public class GenerarSolicitudCrearCategoria {

  //Transformamos el objeto de domnio a un objeto de codigo

  public Categoria crearCategoria(ComandoSolicitudCrearCategoria comandoSolicitudCrearCategoria){
    return Categoria.crearCategoria(comandoSolicitudCrearCategoria.getTitulo(),
      comandoSolicitudCrearCategoria.getDescripcion());
  }
}
