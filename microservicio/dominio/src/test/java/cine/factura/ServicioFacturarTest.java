package cine.factura;

import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.entidad.Cliente;
import cine.cliente.entidad.TipoCliente;
import cine.factura.modelo.entidad.Factura;
import cine.factura.modelo.entidad.ProductoFacturar;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.factura.servicio.ServicioFacturar;
import cine.producto.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

class ServicioFacturarTest {

    @Test
    void deberiaGenerarFacturaYGuardar(){
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .conTipoCliente(TipoCliente.ESPECIAL)
                .reconstruir();
        ProductoFacturar productoFacturarArroz = new ProductoFacturarTestDataBuilder()
                .conCantidad(5)
                .conProducto(new ProductoTestDataBuilder()
                        .conProductoPorDefecto()
                        .conValor(BigDecimal.valueOf(2000))
                        .conAplicaIva(true).conNombre("Arroz")
                        .reconstruir())
                .build();
        var solicitudFacturar = new SolicitudFacturarTestDataBuilder()
                .conProductoFacturar(productoFacturarArroz)
                .conCliente(cliente).build();

        var repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1l);

        var servicioFacturar = new ServicioFacturar(repositorioFactura);

        var idFacturaCreada = servicioFacturar.ejecutar(solicitudFacturar);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).guardar(captorFactura.capture());
        Assertions.assertEquals(cliente, captorFactura.getValue().getCliente());
        Assertions.assertEquals(productoFacturarArroz, captorFactura.getValue().getProductos().get(0));
        Assertions.assertEquals(10710l, captorFactura.getValue().getValorTotal().longValue());
        Assertions.assertEquals(1l, idFacturaCreada);
    }
}
