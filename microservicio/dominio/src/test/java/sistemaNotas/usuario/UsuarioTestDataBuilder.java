package sistemaNotas.usuario;

import sistemaNotas.usuario.modelo.entidad.Rol;
import sistemaNotas.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled = true;
    private Rol rol;

    public UsuarioTestDataBuilder conUsuarioPorDefecto(){
        this.id = 1L;
        this.username = "Cliente 1";
        this.password = "Cliente 1";
        this.nombre = "cliente@mail.com";
        this.apellido = "cliente@mail.com";
        this.email = "cliente@mail.com";
        this.telefono = "admin";
        this.enabled = true;
        this.rol = rol.NORMAL;
        return this;
    }

    public UsuarioTestDataBuilder conUsername(String username){
        this.username = username;
        return this;
    }

    public UsuarioTestDataBuilder conRol(Rol rol){
        this.rol = rol;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioTestDataBuilder conPassword(String password) {
        this.password = password;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioTestDataBuilder isEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Usuario reconstruir() {
        return Usuario.crear(id, nombre, email,nombre,apellido,email,telefono,enabled,rol.toString());
    }

    public Usuario crear(){
        return Usuario.reconstruir(id,nombre,password,rol.toString());
    }
    public Usuario crearConContrasena(){
        return new Usuario(id, username, password,rol.toString());
    }
}
