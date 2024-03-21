package sistemaNotas.examen.adaptador.dao;

import sistemaNotas.examen.adaptador.repositorio.MapeoExamen;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.dao.ExamenDao;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamenDaoPostgres implements ExamenDao {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoExamen mapeoExamen;

    public ExamenDaoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoExamen mapeoExamen) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoExamen = mapeoExamen;
    }

    //region SQLSTATEMENTS
    @SqlStatement(namespace = "examen", value = "obtenertodosexamenes")
    private static String sqlObtenerTodosLosExamenes;
    @SqlStatement(namespace = "examen", value = "obtenerporid")
    private static String sqlObtenerExamen;
    //endregion

    @Override
    public List<Examen> obtenerTodosExamenes() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodosLosExamenes, mapeoExamen);
    }

    @Override
    public Examen obtenerExamen(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerExamen, parameterSource, mapeoExamen));
    }
}
