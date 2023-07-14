package cine.cliente.modelo.entidad;

import cine.dominio.ValidadorArgumento;

import java.util.Date;

public class Cliente {
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
}
