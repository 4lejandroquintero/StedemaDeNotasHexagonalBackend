package cine.cliente.adaptador.dao;

import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.modelo.entidad.Membresia;
import cine.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoClienteDatosPrincipales implements RowMapper<ClienteDatosPrincipalesDTO>, MapperResult {

    @Override
    public ClienteDatosPrincipalesDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre_cliente");
        String documentoIdentidad = resultSet.getString("documento_identidad_cliente");
        Membresia tipoMembresia = Membresia.valueOf(resultSet.getString("membresia_cliente"));
        return new ClienteDatosPrincipalesDTO(id, nombre,documentoIdentidad,tipoMembresia);
    }
}
