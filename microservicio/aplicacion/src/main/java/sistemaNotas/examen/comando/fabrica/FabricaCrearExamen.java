package sistemaNotas.examen.comando.fabrica;

import org.springframework.stereotype.Component;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.CategoriaRepositorio;
import sistemaNotas.examen.comando.ComandoCrearExamen;
import sistemaNotas.examen.modelo.entidad.Examen;

@Component
public class FabricaCrearExamen {
  private final CategoriaRepositorio categoriaRepositorio;

  public FabricaCrearExamen(CategoriaRepositorio categoriaRepositorio) {
    this.categoriaRepositorio = categoriaRepositorio;
  }

  private Categoria obtenerCategoria (Long id){
    return categoriaRepositorio.obtener(id);
  }

  public Examen crear(ComandoCrearExamen comandoCrearExamen) {
    return Examen.crear(obtenerCategoria(comandoCrearExamen.getCategoriaId()), comandoCrearExamen.getTitulo(), comandoCrearExamen.getDescripcion(),
      comandoCrearExamen.getPuntosMaximos(), comandoCrearExamen.getNumeroDePreguntas(), comandoCrearExamen.isActivo());
  }
}
