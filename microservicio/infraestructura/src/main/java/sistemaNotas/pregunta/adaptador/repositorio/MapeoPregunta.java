package sistemaNotas.pregunta.adaptador.repositorio;

import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sistemaNotas.pregunta.entidad.Pregunta;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPregunta implements RowMapper<Pregunta>, MapperResult {

    @Override
    public Pregunta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      Long id = resultSet.getLong("id");
      String contenido = resultSet.getString("contenido");
      String imagen = resultSet.getString("imagen");
      String opcion1 = resultSet.getString("opcion1");
      String opcion2 = resultSet.getString("opcion2");
      String opcion3 = resultSet.getString("opcion3");
      String opcion4 = resultSet.getString("opcion4");
      String respuestaDada = resultSet.getString("respuesta_dada");
      String respuesta = resultSet.getString("respuesta");
        return Pregunta.reconstruir(id, contenido, imagen, opcion1, opcion2, opcion3, opcion4,respuestaDada,respuesta);
    }
}