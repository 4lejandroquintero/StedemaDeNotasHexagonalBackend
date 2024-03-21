package sistemaNotas.categoria.adaptador.dao;

import sistemaNotas.categoria.adaptador.repositorio.MapeoCategoria;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.dao.CategoriaDao;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaDaoPostgres implements CategoriaDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCategoria mapeoCategoria;

    public CategoriaDaoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCategoria mapeoCategoria) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCategoria = mapeoCategoria;
    }
    //region SQLSTATEMENTS

    @SqlStatement(namespace = "categoria", value = "obtenerporid")
    private static String sqlObtenerCategoria;
    //endregion



  @Override
  public Categoria obtenerCategoria(Long id) {
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("id", id);
    return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
      .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerCategoria, parameterSource, mapeoCategoria));
  }
}
