package sistemaNotas.categoria.adaptador.repositorio;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.CategoriaRepositorio;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepoDB implements CategoriaRepositorio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCategoria mapeoCategoria;

    public CategoriaRepoDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCategoria mapeoCategoria) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCategoria = mapeoCategoria;
    }

    @SqlStatement(namespace = "categoria",value = "crearcategoria")
    private static String sqlCrearCategoria;
    @SqlStatement(namespace = "categoria",value = "obtenerporid")
    private static String sqlObtenerPorID;

    @Override
    public Long crearCategoria(Categoria categoria) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", categoria.getCategoriaId());
        parameterSource.addValue("titulo", categoria.getTitulo());
        parameterSource.addValue("descripcion", categoria.getDescripcion());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearCategoria);
    }

    @Override
    public Categoria obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoCategoria));
    }

    @Override
    public boolean existe(Long id) {
        return false;
    }
}
