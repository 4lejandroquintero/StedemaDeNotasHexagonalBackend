package sistemaNotas.usuario.comando;

import sistemaNotas.usuario.modelo.entidad.Rol;

public class ComandoControladorUsuarioTestDataBuilder {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled;
    private Rol rol;

    public ComandoControladorUsuarioTestDataBuilder crearPorDefecto() {
        this.username = "alejoq96";
        this.password = "12345";
        this.nombre = "Alejandro";
        this.apellido = "Quintero";
        this.email = "alejoq96@gmail.com";
        this.telefono = "123456789";
        this.enabled = true;
        this.rol = rol.ADMIN;
        return this;
    }

    public ComandoSolicitudCrearUsuario build(){
        return new ComandoSolicitudCrearUsuario(username, password, nombre, apellido, email, telefono, enabled, rol.toString());
    }
}
