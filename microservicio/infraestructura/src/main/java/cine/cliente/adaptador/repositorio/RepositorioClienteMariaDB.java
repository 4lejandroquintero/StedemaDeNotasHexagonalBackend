package cine.cliente.adaptador.repositorio;

import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.puerto.RepositorioCliente;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMariaDB implements RepositorioCliente {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCliente mapeoCliente;
    @SqlStatement(namespace = "cliente", value = "crearcliente")
    private static String sqlCrearCliente;

    @SqlStatement(namespace = "cliente", value = "obtenerporid")
    private static String sqlObtenerPorID;

    public RepositorioClienteMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCliente mapeoCliente) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCliente = mapeoCliente;
    }

    @Override
    public Long crear(Cliente cliente) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", cliente.getIdCliente());
        parameterSource.addValue("nombre_cliente", cliente.getNombre());
        parameterSource.addValue("email_cliente", cliente.getEmail());
        parameterSource.addValue("contrasena_cliente", cliente.getContrasena());
        parameterSource.addValue("documento_identidad_cliente", cliente.getDocumentoIdentidad());
        parameterSource.addValue("membresia_cliente", cliente.getTipoMembresia().name());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearCliente);
    }
    @Override
    public Cliente obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoCliente));
    }
}
