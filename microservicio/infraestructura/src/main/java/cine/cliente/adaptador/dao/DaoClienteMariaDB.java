package cine.cliente.adaptador.dao;

import cine.cliente.adaptador.repositorio.MapeoClienteCompleto;
import cine.cliente.adaptador.repositorio.MapeoDatosCliente;
import cine.cliente.modelo.dto.ClienteDatosCompletos;
import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.puerto.dao.DaoCliente;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoClienteMariaDB implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoClienteDatosPrincipales mapeoClienteDatosPrincipales;

    private final MapeoDatosCliente mapeoDatosCliente;

    @SqlStatement(namespace = "cliente", value="obtenerdatosclientes")
    private static String sqlObtenerDatosClientes;
    @SqlStatement(namespace = "cliente", value = "obtenerdatosprincipalesporid")
    private static String sqlObtenerDatosPrincipalesPorId;
    @SqlStatement(namespace = "cliente", value = "obtenerporid")
    private static String sqlObtenerFullDatos;
    public DaoClienteMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoClienteDatosPrincipales mapeoClienteDatosPrincipales, MapeoClienteCompleto mapeoClienteCompleto, MapeoDatosCliente mapeoDatosCliente) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoClienteDatosPrincipales = mapeoClienteDatosPrincipales;
        this.mapeoDatosCliente = mapeoDatosCliente;
    }

    @Override
    public List<ClienteDatosPrincipalesDTO> obtenerDatosClientes() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerDatosClientes, mapeoClienteDatosPrincipales);
    }

    @Override
    public ClienteDatosPrincipalesDTO obtenerDatosClientePorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerDatosPrincipalesPorId,
                parameterSource, new MapeoClienteDatosPrincipales()));
    }

    @Override
    public ClienteDatosCompletos obtenerFullDatosClientePorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerFullDatos,
                parameterSource, mapeoDatosCliente));
    }
}
