package cine.cliente.comando;

import cine.cliente.modelo.entidad.Membresia;

public class ComandoControladorClienteTestDataBuilder {
    private String nombre;
    private String email;
    private String contrasena;
    private String documentoIdentidad;
    private Membresia tipoMembresia;

    public ComandoControladorClienteTestDataBuilder crearPorDefecto() {
        this.nombre = "Cliente 1";
        this.email = "cliente@mail.com";
        this.contrasena = "admin";
        this.documentoIdentidad = "123456789";
        this.tipoMembresia = Membresia.ZAFIRO;
        return this;
    }

    public ComandoSolicitudCrearCliente build(){
        return new ComandoSolicitudCrearCliente(nombre, email, contrasena, documentoIdentidad, tipoMembresia);
    }
}
