package cine.funcion.adaptador.dao;

import cine.funcion.adaptador.repositorio.MapeoFuncion;
import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.dao.DaoFuncion;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoFuncionMariaDB  implements DaoFuncion {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFuncion mapeoFuncion;

    public DaoFuncionMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFuncion mapeoFuncion) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFuncion = mapeoFuncion;
    }

    //region SQLSTATEMENTS
    @SqlStatement(namespace = "funcion", value = "obtenertodasfunciones")
    private static String sqlObtenerTodasLasFunciones;
    @SqlStatement(namespace = "funcion", value = "obtenerporid")
    private static String sqlObtenerFuncion;
    //endregion

    @Override
    public List<Funcion> obtenerTodasFunciones() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodasLasFunciones, mapeoFuncion);
    }

    @Override
    public Funcion obtenerFuncion(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_funcion", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerFuncion, parameterSource, mapeoFuncion));
    }
}
