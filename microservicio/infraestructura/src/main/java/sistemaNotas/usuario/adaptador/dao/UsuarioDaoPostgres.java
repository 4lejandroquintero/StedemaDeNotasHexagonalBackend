package sistemaNotas.usuario.adaptador.dao;

import sistemaNotas.usuario.adaptador.repositorio.MapeoUsuarioCompleto;
import sistemaNotas.usuario.adaptador.repositorio.MapeoDatosUsuario;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosCompletos;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.usuario.puerto.dao.UsuarioDao;

import java.util.List;

@Repository
public class UsuarioDaoPostgres implements UsuarioDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoUsuarioDatosPrincipales mapeoUsuarioDatosPrincipales;

    private final MapeoDatosUsuario mapeoDatosUsuario;

    @SqlStatement(namespace = "usuario", value="obtenerdatosusuarios")
    private static String sqlObtenerDatosUsuarios;
    @SqlStatement(namespace = "usuario", value = "obtenerdatosprincipalesporid")
    private static String sqlObtenerDatosPrincipalesPorId;
    @SqlStatement(namespace = "usuario", value = "obtenerporid")
    private static String sqlObtenerFullDatos;
    public UsuarioDaoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoUsuarioDatosPrincipales mapeoUsuarioDatosPrincipales, MapeoUsuarioCompleto mapeoUsuarioCompleto, MapeoDatosUsuario mapeoDatosUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoUsuarioDatosPrincipales = mapeoUsuarioDatosPrincipales;
        this.mapeoDatosUsuario = mapeoDatosUsuario;
    }

    @Override
    public List<UsuarioDatosPrincipalesDTO> obtenerDatosUsuarios() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerDatosUsuarios, mapeoUsuarioDatosPrincipales);
    }

  @Override
    public UsuarioDatosPrincipalesDTO obtenerDatosUsuarioID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerDatosPrincipalesPorId,
                parameterSource, new MapeoUsuarioDatosPrincipales()));
    }

    @Override
    public UsuarioDatosCompletos obtenerFullDatosUsuarioID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerFullDatos,
                parameterSource, mapeoDatosUsuario));
    }


}
