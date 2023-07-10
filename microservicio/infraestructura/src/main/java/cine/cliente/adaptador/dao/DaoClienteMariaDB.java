package cine.cliente.adaptador.dao;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.puerto.dao.DaoCliente;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DaoClienteMariaDB implements DaoCliente {

    private final JdbcTemplate jdbcTemplate;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoClienteDatosPrincipales mapeoClienteDatosPrincipales;

    @SqlStatement(namespace = "cliente", value="obtenerdatosclientes")
    private static String sqlObtenerDatosClientes;
    @SqlStatement(namespace = "cliente", value = "obtenerdatosprincipalesporid")
    private static String sqlObtenerDatosPrincipalesPorId;
    public DaoClienteMariaDB(JdbcTemplate jdbcTemplate, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoClienteDatosPrincipales mapeoClienteDatosPrincipales) {
        this.jdbcTemplate = jdbcTemplate;
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoClienteDatosPrincipales = mapeoClienteDatosPrincipales;
    }

    @Override
    public List<ClienteDatosPrincipalesDTO> obtenerDatosClientes() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerDatosClientes, mapeoClienteDatosPrincipales);
    }

    @Override
    public Optional<ClienteDatosPrincipalesDTO> obtenerDatosClientePorID(Long id) {
        return jdbcTemplate.query(sqlObtenerDatosPrincipalesPorId,new MapeoClienteDatosPrincipales(),id).stream().findFirst();
    }
}
