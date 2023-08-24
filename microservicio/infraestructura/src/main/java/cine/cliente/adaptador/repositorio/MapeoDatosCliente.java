package cine.cliente.adaptador.repositorio;

import cine.cliente.modelo.dto.ClienteDatosCompletos;
import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.modelo.entidad.Membresia;
import cine.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoDatosCliente implements RowMapper<ClienteDatosCompletos>, MapperResult {
    @Override
    public ClienteDatosCompletos mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idCliente = resultSet.getLong("id");
        String nombre  = resultSet.getString("nombre_cliente");
        String email= resultSet.getString("email_cliente");
        String contrasena= resultSet.getString("contrasena_cliente");
        String documentoIdentidad= resultSet.getString("documento_identidad_cliente");
        Membresia tipoMembresia = Membresia.valueOf(resultSet.getString("membresia_cliente"));
        return new ClienteDatosCompletos(idCliente, nombre, email, contrasena, documentoIdentidad , tipoMembresia.toString());
    }
}
