package cine.factura;

import cine.boleto.BoletoTestDataBuilder;
import cine.boleto.entidad.Boleto;
import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.modelo.entidad.Membresia;
import cine.factura.modelo.entidad.Factura;
import cine.factura.modelo.entidad.SolicitudFacturar;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.factura.servicio.ServicioFacturar;
import cine.funcion.FuncionTestDataBuilder;
import cine.funcion.modelo.entidad.Funcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;

class ServicioFacturarTest {
    @Test
    void deberiaGenerarFacturaYGuardar(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();

        SolicitudFacturar solicitudFacturar = new SolicitudFacturarTestDataBuilder().conCliente(cliente).conBoleto(boleto).construir();

        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1L);

        ServicioFacturar servicioFacturar = new ServicioFacturar(repositorioFactura);

        Long idFacturaCreada = servicioFacturar.ejecutar(solicitudFacturar);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).guardar(captorFactura.capture());
        Assertions.assertEquals(cliente, captorFactura.getValue().getCliente());
        Assertions.assertEquals(boleto, captorFactura.getValue().getBoleto());
        Assertions.assertEquals(1L, idFacturaCreada);
    }

    @Test
    void deberiaGenerarFacturaYGuardarConClienteTipoMemebresiaRuby(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().conTipoMembresia(Membresia.RUBY).reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();

        SolicitudFacturar solicitudFacturar = new SolicitudFacturarTestDataBuilder().conCliente(cliente).conBoleto(boleto).construir();

        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1L);

        ServicioFacturar servicioFacturar = new ServicioFacturar(repositorioFactura);

        Long idFacturaCreada = servicioFacturar.ejecutar(solicitudFacturar);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).guardar(captorFactura.capture());
        Assertions.assertEquals(cliente, captorFactura.getValue().getCliente());
        Assertions.assertEquals(boleto, captorFactura.getValue().getBoleto());
        Assertions.assertEquals(1L, idFacturaCreada);
    }
    @Test
    void deberiaGenerarFacturaYGuardarConClienteTipoMemebresiaEsmeralda(){
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().conTipoMembresia(Membresia.ESMERALDA).reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();

        SolicitudFacturar solicitudFacturar = new SolicitudFacturarTestDataBuilder().conCliente(cliente).conBoleto(boleto).construir();

        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1L);

        ServicioFacturar servicioFacturar = new ServicioFacturar(repositorioFactura);

        Long idFacturaCreada = servicioFacturar.ejecutar(solicitudFacturar);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).guardar(captorFactura.capture());
        Assertions.assertEquals(cliente, captorFactura.getValue().getCliente());
        Assertions.assertEquals(boleto, captorFactura.getValue().getBoleto());
        Assertions.assertEquals(1L, idFacturaCreada);
    }
}
