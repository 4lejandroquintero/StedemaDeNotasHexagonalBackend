package cine.cliente;

import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.modelo.entidad.Membresia;

public class ClienteTestDataBuilder {
    private Long idCliente;
    private String nombre;
    private String email;
    private String contrasena;
    private String documentoIdentidad;
    private Membresia tipoMembresia;

    public ClienteTestDataBuilder conClientePorDefecto(){
        this.idCliente = 1L;
        this.nombre = "Cliente 1";
        this.email = "cliente@mail.com";
        this.contrasena = "admin";
        this.documentoIdentidad = "123456789";
        this.tipoMembresia = Membresia.RUBY;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conTipoMembresia(Membresia tipoMembresia){
        this.tipoMembresia = tipoMembresia;
        return this;
    }

    public ClienteTestDataBuilder conId(Long idCliente){
        this.idCliente = idCliente;
        return this;
    }

    public ClienteTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteTestDataBuilder conDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
        return this;
    }

    public ClienteTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public Cliente reconstruir() {
        return Cliente.crear(idCliente, nombre, email,documentoIdentidad,tipoMembresia);
    }

    public Cliente crear(){
        return Cliente.reconstruir(idCliente,nombre,documentoIdentidad,tipoMembresia);
    }
    public Cliente crearConContrasena(){
        return new Cliente(idCliente,nombre,email,contrasena,documentoIdentidad,tipoMembresia);
    }
}
