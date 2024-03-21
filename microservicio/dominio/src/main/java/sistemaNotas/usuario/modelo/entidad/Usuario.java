package sistemaNotas.usuario.modelo.entidad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sistemaNotas.dominio.ValidadorArgumento;

import java.util.Collection;

public class Usuario implements UserDetails {
  private Long id;
  private String username;
  private String password;
  private String nombre;
  private String apellido;
  private String email;
  private String telefono;
  private boolean enabled = true;
  private String rol;

  public Usuario(Long id, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String rol) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.enabled = enabled;
    this.rol = rol;
  }

  public Usuario(String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String rol) {
    this.username = username;
    this.password = password;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.enabled = enabled;
    this.rol = rol;
  }

  public Usuario(Long id, String username, String password, String rol) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.rol = rol;
  }

  public static Usuario reconstruir(Long id, String username, String password, String rol) {
    ValidadorArgumento.validarObligatorio(id, "El ID del usuario es obligatorio");
    ValidadorArgumento.validarObligatorio(username, "El username del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(password, "El password del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(rol, "El perfil del usuario es Obligatorio");
    return new Usuario(id, username, password, rol );
  }

  public static Usuario reconstruirCompleto(Long id, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String rol) {
    ValidadorArgumento.validarObligatorio(id, "El ID del usuario es obligatorio");
    ValidadorArgumento.validarObligatorio(username, "El username del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(password, "El password del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(nombre, "El nombre del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(apellido, "El apellido del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(email, "El email del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(telefono, "El telefono del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(enabled, "El estado del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(rol, "El perfil del usuario es Obligatorio");
    return new Usuario(id, username, password, nombre, apellido, email, telefono, enabled, rol );
  }


  public static Usuario crear(Long id, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String rol) {
    ValidadorArgumento.validarObligatorio(id, "El ID del usuario es obligatorio");
    ValidadorArgumento.validarObligatorio(username, "El username del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(password, "El password del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(nombre, "El nombre del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(apellido, "El apellido del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(email, "El email del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(telefono, "El telefono del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(enabled, "El estado del usuario es Obligatorio");
    ValidadorArgumento.validarObligatorio(rol, "El perfil del usuario es Obligatorio");
    return new Usuario(id, username, password, nombre, apellido, email, telefono, enabled, rol );
  }

  public static void eliminar(Long id) {
      ValidadorArgumento.validarObligatorio(id, "El ID del usuario es obligatorio para eliminar");
  }

 public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getEmail() {
    return email;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getRol() {
    return rol;
  }

  public boolean esPerfilAdmin() {
    return this.rol.equals(Rol.ADMIN);
  }

  public boolean esPerfilNormal() {
    return this.rol.equals(Rol.NORMAL);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
