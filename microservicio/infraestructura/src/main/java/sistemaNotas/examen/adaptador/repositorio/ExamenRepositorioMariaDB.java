package sistemaNotas.examen.adaptador.repositorio;

import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class ExamenRepositorioMariaDB implements ExamenRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoExamen mapeoExamen;

    public ExamenRepositorioMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoExamen mapeoExamen) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoExamen = mapeoExamen;
    }

    @SqlStatement(namespace = "examen", value = "crearexamen")
    private static String sqlCrearExamen;

    @SqlStatement(namespace = "examen", value = "obtenerporid")
    private static String sqlObtenerExamen;

    @Override
    public Long crear(Examen examen) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", examen.getExamenId());
        parameterSource.addValue("id_pregunta", examen.getPregunta().getPreguntaId());
        parameterSource.addValue("titulo", examen.getTitulo());
        parameterSource.addValue("descripcion", examen.getDescripcion());
        parameterSource.addValue("puntos_maximo", examen.getPuntosMaximos());
        parameterSource.addValue("numero_de_preguntas", examen.getNumeroDePreguntas());
        parameterSource.addValue("activo", examen.isActivo());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearExamen);
    }

    @Override
    public Examen obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerExamen, parameterSource, mapeoExamen));
    }

}
