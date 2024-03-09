package sistemaNotas.examen.servicio;

import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;

public class ServicioCrearExamen {
  private final ExamenRepositorio examenRepositorio;


  public ServicioCrearExamen(ExamenRepositorio examenRepositorio) {
    this.examenRepositorio = examenRepositorio;
  }

  public Long ejecutar(Examen examen){
    return this.examenRepositorio.crear(examen);
  }
}
