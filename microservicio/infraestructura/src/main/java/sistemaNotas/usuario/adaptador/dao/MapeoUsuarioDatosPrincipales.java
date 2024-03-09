package sistemaNotas.usuario.adaptador.dao;

import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sistemaNotas.usuario.modelo.entidad.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoUsuarioDatosPrincipales implements RowMapper<UsuarioDatosPrincipalesDTO>, MapperResult {
    @Override
    public UsuarioDatosPrincipalesDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idUsuario = resultSet.getLong("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        Rol rol = Rol.valueOf(resultSet.getString("rol"));
        return new UsuarioDatosPrincipalesDTO(idUsuario, username,password,rol);
    }
}
