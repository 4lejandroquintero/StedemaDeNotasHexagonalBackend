package sistemaNotas.pregunta.adaptador.dao;

import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import sistemaNotas.pregunta.adaptador.repositorio.MapeoPregunta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import sistemaNotas.pregunta.entidad.Pregunta;
import sistemaNotas.pregunta.entidad.dto.PreguntaDTO;
import sistemaNotas.pregunta.puerto.dao.PreguntaDao;

import java.util.List;

@Repository
public class PreguntaDaoPostgres implements PreguntaDao {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoPreguntaDTO mapeoPreguntaDTO;
    public PreguntaDaoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPreguntaDTO mapeoPreguntaDTO) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPreguntaDTO = mapeoPreguntaDTO;
    }

    //SQLSTATEMENTS
    @SqlStatement(namespace = "pregunta", value = "obtenerporid")
    private static String sqlObtenerPreguntaPorID;

    @SqlStatement(namespace = "pregunta", value = "obtenerpreguntas")
    private static String sqlObtenerTodasLasPreguntas;

    @Override
    public List<PreguntaDTO> obtenerTodasPreguntas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodasLasPreguntas, mapeoPreguntaDTO);
    }

    @Override
    public Pregunta obtenerPreguntaPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPreguntaPorID,
                parameterSource, new MapeoPregunta()));
    }
}
