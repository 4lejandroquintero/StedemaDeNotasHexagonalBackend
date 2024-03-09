package sistemaNotas.usuario.adaptador.repositorio;

import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sistemaNotas.usuario.modelo.entidad.Rol;
import sistemaNotas.usuario.modelo.entidad.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoUsuarioCompleto implements RowMapper<Usuario>, MapperResult {
    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idUsuario = resultSet.getLong("id");
        String username  = resultSet.getString("username");
        String password= resultSet.getString("password");
        String nombre= resultSet.getString("nombre");
        String apellido= resultSet.getString("apellido");
        String email= resultSet.getString("email");
        String telefono= resultSet.getString("telefono");
        boolean enabled= resultSet.getBoolean("enabled");
        Rol rol = Rol.valueOf(resultSet.getString("rol"));
        return Usuario.reconstruirCompleto(idUsuario, username, password, nombre, apellido , email, telefono, enabled, rol.toString());
    }
}
