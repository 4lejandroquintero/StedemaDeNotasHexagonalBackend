package cine.cliente.modelo.entidad;

import cine.dominio.ValidadorArgumento;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class Cliente implements UserDetails {
    private  Long idCliente;
    private  String nombre;
    private  String email;
    private  String contrasena;
    private  String documentoIdentidad;
    private  Membresia tipoMembresia;


    public Cliente(Long idCliente, String nombre, String email, String contrasena, String documentoIdentidad, Membresia tipoMembresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.documentoIdentidad = documentoIdentidad;
        this.tipoMembresia = tipoMembresia;
    }

    public Cliente(String nombre, String email, String contrasena, String documentoIdentidad, Membresia tipoMembresia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.documentoIdentidad = documentoIdentidad;
        this.tipoMembresia = tipoMembresia;
    }

    public Cliente(Long idCliente, String nombre, String documentoIdentidad, Membresia tipoMembresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.tipoMembresia = tipoMembresia;
    }

    public static Cliente reconstruir(Long idCliente, String nombre, String documentoIdentidad, Membresia tipoMembresia){
        ValidadorArgumento.validarObligatorio(idCliente, "Es necesario ingresar el id del cliente");
        ValidadorArgumento.validarObligatorio(nombre, "Es necesario ingresar el nombre del cliente");
        ValidadorArgumento.validarObligatorio(documentoIdentidad, "Es necesario ingresar el documento de identidad del cliente");
        ValidadorArgumento.validarObligatorio(tipoMembresia, "Es necesario ingresar el tipo de membresia del cliente");
        return new Cliente(idCliente,nombre, documentoIdentidad, tipoMembresia);
    }

    public static Cliente reconstruirCompleto(Long idCliente, String nombre, String email, String contrasena, String documentoIdentidad, Membresia tipoMembresia){
        ValidadorArgumento.validarObligatorio(idCliente, "Es necesario ingresar el id del cliente");
        ValidadorArgumento.validarObligatorio(nombre, "Es necesario ingresar el nombre del cliente");
        ValidadorArgumento.validarObligatorio(email, "Es necesario ingresar el email del cliente");
        ValidadorArgumento.validarObligatorio(contrasena, "Es necesario ingresar la contrasena del cliente");
        ValidadorArgumento.validarObligatorio(documentoIdentidad, "Es necesario ingresar el documento de identidad del cliente");
        ValidadorArgumento.validarObligatorio(tipoMembresia, "Es necesario ingresar el tipo de membresia del cliente");
        return new Cliente(idCliente,nombre,email, contrasena,  documentoIdentidad, tipoMembresia);
    }

    public Cliente(Long idCliente, String nombre, String email, String documentoIdentidad, Membresia tipoMembresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.documentoIdentidad = documentoIdentidad;
        this.tipoMembresia = tipoMembresia;
    }

    public static Cliente crear(Long idCliente, String nombre, String email, String documentoIdentidad, Membresia tipoMembresia){
        ValidadorArgumento.validarObligatorio(idCliente, "Es necesario ingresar el id del cliente");
        ValidadorArgumento.validarObligatorio(nombre, "Es necesario ingresar el nombre del cliente");
        ValidadorArgumento.validarObligatorio(email, "Es necesario ingresar el email del cliente");
        ValidadorArgumento.validarObligatorio(documentoIdentidad, "Es necesario ingresar el documento de identidad del cliente");
        ValidadorArgumento.validarObligatorio(tipoMembresia, "Es necesario ingresar el tipo de membresia del cliente");
        return new Cliente(idCliente,nombre, email,documentoIdentidad, tipoMembresia);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Membresia getTipoMembresia() {
        return tipoMembresia;
    }

    public boolean esMembresiaEsmeralda(){
        return this.tipoMembresia.equals(Membresia.ESMERALDA);
    }
    public boolean esMembresiaZafiro(){
        return this.tipoMembresia.equals(Membresia.ZAFIRO);
    }
    public boolean esMembresiaRuby(){
        return this.tipoMembresia.equals(Membresia.RUBY);
    }

    public Long getIdCliente() {
        return idCliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getContrasena();
    }

    @Override
    public String getUsername() {
        return this.nombre;
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
        return true;
    }
}
