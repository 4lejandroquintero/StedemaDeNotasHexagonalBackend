package sistemaNotas.pregunta.adaptador.repositorio;

import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPregunta implements RowMapper<Pregunta>, MapperResult {
    private final ExamenRepositorio examenRepositorio;

    public MapeoPregunta(ExamenRepositorio examenRepositorio) {
        this.examenRepositorio = examenRepositorio;
    }


    @Override
    public Pregunta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      Long idPregunta = resultSet.getLong("id");
      Long idExamen = resultSet.getLong("examenId");
      String contenido = resultSet.getString("contenido");
      String imagen = resultSet.getString("imagen");
      String opcion1 = resultSet.getString("opcion1");
      String opcion2 = resultSet.getString("opcion2");
      String opcion3 = resultSet.getString("opcion3");
      String opcion4 = resultSet.getString("opcion4");
      String respuestaDada = resultSet.getString("respuesta_dada");
      String respuesta = resultSet.getString("respuesta");
        return Pregunta.reconstruir(idPregunta, examenRepositorio.obtener(idExamen),contenido, imagen, opcion1, opcion2, opcion3, opcion4,respuestaDada,respuesta);
    }
}
