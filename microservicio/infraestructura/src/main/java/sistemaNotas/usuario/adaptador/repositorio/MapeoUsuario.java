package sistemaNotas.usuario.adaptador.repositorio;

import org.springframework.jdbc.core.RowMapper;
import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.stereotype.Component;
import sistemaNotas.usuario.modelo.entidad.Rol;
import sistemaNotas.usuario.modelo.entidad.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;



@Component
public class MapeoUsuario implements RowMapper<Usuario>, MapperResult {
    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String username  = resultSet.getString("username");
        String password= resultSet.getString("password");
        Rol rol = Rol.valueOf(resultSet.getString("rol"));
        return Usuario.reconstruir(id, username, password, rol.toString());
    }
}
