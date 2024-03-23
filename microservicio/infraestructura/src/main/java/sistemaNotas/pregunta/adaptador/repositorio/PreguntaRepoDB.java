package sistemaNotas.pregunta.adaptador.repositorio;

import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;

@Repository
public class PreguntaRepoDB implements PreguntaRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @Autowired
    private final MapeoPregunta mapeoPregunta;

    public PreguntaRepoDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPregunta mapeoPregunta) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPregunta = mapeoPregunta;
    }

    @SqlStatement(namespace = "pregunta", value = "crearpregunta")
    private static String sqlCrearPregunta;

    @SqlStatement(namespace = "pregunta", value = "obtenerporid")
    private static String sqlObtenerPregunta;



    @Override
    public Long crear(Pregunta pregunta) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", pregunta.getPreguntaId());
        parameterSource.addValue("examenId", pregunta.getExamen().getExamenId());
        parameterSource.addValue("contenido", pregunta.getContenido());
        parameterSource.addValue("imagen", pregunta.getImagen());
        parameterSource.addValue("opcion1", pregunta.getOpcion1());
        parameterSource.addValue("opcion2", pregunta.getOpcion2());
        parameterSource.addValue("opcion3", pregunta.getOpcion3());
        parameterSource.addValue("opcion4", pregunta.getOpcion4());
        parameterSource.addValue("respuesta_dada", pregunta.getRespuestaDada());
        parameterSource.addValue("respuesta", pregunta.getRespuesta());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource,sqlCrearPregunta);
    }

    @Override
    public Pregunta obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPregunta, parameterSource, mapeoPregunta));
    }
}
