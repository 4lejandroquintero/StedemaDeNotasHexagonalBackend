package cine.configuracion;

import cine.boleto.puerto.RepositorioBoleto;
import cine.boleto.servicio.ServicioCrearBoleto;
import cine.cliente.puerto.RepositorioCliente;
import cine.cliente.servicio.ServicioActualizarCliente;
import cine.cliente.servicio.ServicioCrearCliente;
import cine.cliente.servicio.ServicioEliminarCliente;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.factura.servicio.ServicioAnular;
import cine.factura.servicio.ServicioFacturar;
import cine.funcion.puerto.RepositorioFuncion;
import cine.funcion.servicio.ServicioCrearFuncion;
import cine.pago.puerto.RepositorioPago;
import cine.pago.servicio.ServicioRealizarPago;
import cine.pelicula.puerto.RepositorioPelicula;
import cine.pelicula.servicio.ServicioCrearPelicula;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    //region Factura
    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }
    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }
    //endregion

    //region Cliente
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }
    //endregion

    //region Pelicula
    @Bean
    public ServicioCrearPelicula servicioCrearPelicula(RepositorioPelicula repositorioPelicula){
        return new ServicioCrearPelicula(repositorioPelicula);
    }
    //endregion

    //region Funcion
    @Bean
    public ServicioCrearFuncion servicioCrearFuncion(RepositorioFuncion repositorioFuncion){
        return new ServicioCrearFuncion(repositorioFuncion);
    }

    //endregion

    //region Boleto
    @Bean
    public ServicioCrearBoleto servicioCrearBoleto(RepositorioBoleto repositorioBoleto){
        return new ServicioCrearBoleto(repositorioBoleto);
    }
    //endregion

    //region Pago
    @Bean
    ServicioRealizarPago servicioRealizarPago(RepositorioPago repositorioPago){
        return new ServicioRealizarPago(repositorioPago);
    }
    //endregion
}
