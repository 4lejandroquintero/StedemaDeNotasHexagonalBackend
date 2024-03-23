package sistemaNotas.pregunta.adaptador.dao;

import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import sistemaNotas.pregunta.adaptador.repositorio.MapeoPregunta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

import java.util.List;

@Repository
public class PreguntaDaoPostgres implements PreguntaDao {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoPregunta mapeoPregunta;

    public PreguntaDaoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPregunta mapeoPregunta) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPregunta = mapeoPregunta;
    }

    //SQLSTATEMENTS
    @SqlStatement(namespace = "pregunta", value = "obtenertodaspreguntas")
    private static String sqlObtenerTodasLasPreguntas;

    @SqlStatement(namespace = "pregunta", value = "obtenerporid")
    private static String sqlObtenerPregunta;

    @Override
    public List<Pregunta> obtenerTodasPreguntas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodasLasPreguntas, mapeoPregunta);
    }

    @Override
    public Pregunta obtenerPregunta(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPregunta, parameterSource, mapeoPregunta));
    }
}
