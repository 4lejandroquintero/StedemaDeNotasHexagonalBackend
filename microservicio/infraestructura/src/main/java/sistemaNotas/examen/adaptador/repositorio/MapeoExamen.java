package sistemaNotas.examen.adaptador.repositorio;

import sistemaNotas.categoria.puerto.CategoriaRepositorio;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.infraestructura.jdbc.MapperResult;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class MapeoExamen implements RowMapper<Examen>, MapperResult {
    private final CategoriaRepositorio categoriaRepositorio;

    public MapeoExamen(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }


    @Override
    public Examen mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idExamen = resultSet.getLong("id");
        Long idCategoria = resultSet.getLong("categoriaId");
        String titulo = resultSet.getString("titulo");
        String descripcion = resultSet.getString("descripcion");
        String puntosMaximo = resultSet.getString("puntos_maximos");
        String numeroDePreguntas = resultSet.getString("numero_de_preguntas");
        boolean activo = resultSet.getBoolean("activo");
        return Examen.reconstruir(idExamen, categoriaRepositorio.obtener(idCategoria), titulo, descripcion, puntosMaximo, numeroDePreguntas,
          activo);
    }
}
