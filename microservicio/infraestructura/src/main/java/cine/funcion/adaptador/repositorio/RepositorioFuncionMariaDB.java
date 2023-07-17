package cine.funcion.adaptador.repositorio;

import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.RepositorioFuncion;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioFuncionMariaDB implements RepositorioFuncion {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFuncion mapeoFuncion;

    public RepositorioFuncionMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFuncion mapeoFuncion) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFuncion = mapeoFuncion;
    }

    @SqlStatement(namespace = "funcion", value = "crearfuncion")
    private static String sqlCrearFuncion;

    @SqlStatement(namespace = "funcion", value = "obtenerporid")
    private static String sqlObtenerFuncion;

    @Override
    public Long crear(Funcion funcion) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", funcion.getIdFuncion());
        parameterSource.addValue("id_pelicula", funcion.getPelicula().getIdPelicula());
        parameterSource.addValue("nombre_teatro_funcion", funcion.getNombreTeatro());
        parameterSource.addValue("sala_funcion", funcion.getSalaFuncion());
        parameterSource.addValue("dia_funcion", funcion.getDiaFuncion());
        parameterSource.addValue("hora_funcion", funcion.getHoraFuncion());
        parameterSource.addValue("valor_funcion", funcion.getValorFuncion());
        parameterSource.addValue("categoria_audio_funcion", funcion.getCategoriaAudioFuncion());
        parameterSource.addValue("categoria_subtitulos_funcion", funcion.getCategoriaSubtitulosFuncion());
        parameterSource.addValue("categoria_dimension_visual_funcion", funcion.getCategoriaVisualFuncion());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearFuncion);
    }

    @Override
    public Funcion obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerFuncion, parameterSource, mapeoFuncion));
    }

}
