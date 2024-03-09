package sistemaNotas.usuario.adaptador.repositorio;

import sistemaNotas.usuario.modelo.entidad.Usuario;
import sistemaNotas.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import sistemaNotas.infraestructura.jdbc.EjecucionBaseDeDatos;
import sistemaNotas.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import sistemaNotas.usuario.puerto.UsuarioRepositorio;

@Repository
public class UsuarioRepositorioMariaDB implements UsuarioRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoUsuario mapeoUsuario;
    private final MapeoUsuarioCompleto mapeoUsuarioCompleto;

    @SqlStatement(namespace = "usuario", value = "crearusuario")
    private static String sqlCrearUsuario;

    @SqlStatement(namespace = "usuario", value = "obtenerporid")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "usuario", value = "autenticar")
    private static String sqlObtenerPorEmail;

    public UsuarioRepositorioMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoUsuario mapeoUsuario, MapeoUsuarioCompleto mapeoUsuarioCompleto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoUsuario = mapeoUsuario;
        this.mapeoUsuarioCompleto = mapeoUsuarioCompleto;
    }

    @Override
    public Long crear(Usuario usuario) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", usuario.getId());
        parameterSource.addValue("username", usuario.getUsername());
        parameterSource.addValue("password", usuario.getPassword());
        parameterSource.addValue("nombre", usuario.getNombre());
        parameterSource.addValue("apellido", usuario.getApellido());
        parameterSource.addValue("email", usuario.getEmail());
        parameterSource.addValue("telefono", usuario.getTelefono());
        parameterSource.addValue("enabled", usuario.isEnabled());
        parameterSource.addValue("rol", usuario.getRol());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearUsuario);
    }

    @Override
    public Usuario consultar(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorEmail, parameterSource, mapeoUsuarioCompleto));
    }

    @Override
    public Usuario obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoUsuario));
    }
}
