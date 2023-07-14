package cine.cliente;


import cine.cliente.modelo.entidad.Membresia;
import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClienteTest {
    @Test
    void deberiaCrearClienteExitoso(){

        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();

        Assertions.assertEquals(1L, cliente.getIdCliente());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("cliente@mail.com", cliente.getEmail());
        Assertions.assertEquals("123456789", cliente.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.ZAFIRO, cliente.getTipoMembresia());
    }
    @Test
    void deberiaCrearClienteExitosoConContrasena(){

        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().crearConContrasena();

        Assertions.assertEquals(1L, cliente.getIdCliente());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("admin", cliente.getContrasena());
        Assertions.assertEquals("cliente@mail.com", cliente.getEmail());
        Assertions.assertEquals("123456789", cliente.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.ZAFIRO, cliente.getTipoMembresia());
    }

    @Test
    void reconstruirClienteSinTipoDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                .conId(1L)
                .conNombre("Cliente 1")
                .conEmail("cliente@mail.com")
                .conContrasena("admin")
                .conDocumentoIdentidad("123456789").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el tipo de membresia del cliente");
    }

    @Test
    void reconstruirClienteSinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                .conId(1L)
                .conEmail("cliente@mail.com")
                .conContrasena("admin")
                .conDocumentoIdentidad("123456789")
                .conTipoMembresia(Membresia.ZAFIRO).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el nombre del cliente");
    }

    @Test
    void reconstruirClienteSinIdDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                .conId(null)
                .conNombre("Cliente 1")
                .conEmail("cliente@mail.com")
                .conContrasena("admin")
                .conDocumentoIdentidad("123456789")
                .conTipoMembresia(Membresia.ZAFIRO).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el id del cliente");
    }

    @Test
    void deberiaResponderEsClientePreferenciaCorrectamente(){
        var cliente = new ClienteTestDataBuilder()
                .conId(1l)
                .conNombre("Cliente 1")
                .conEmail("cliente@mail.com")
                .conContrasena("admin")
                .conDocumentoIdentidad("123456789")
                .conTipoMembresia(Membresia.ZAFIRO).reconstruir();
        Assertions.assertTrue(cliente.esMembresiaZafiro());
        Assertions.assertFalse(cliente.esMembresiaEsmeralda());
    }

    @Test
    void deberiaResponderEsClienteEspecialCorrectamente(){
        var cliente = new ClienteTestDataBuilder()
                .conTipoMembresia(Membresia.RUBY)
                .conId(1l)
                .conNombre("Cliente 1")
                .conEmail("cliente@mail.com")
                .conContrasena("admin")
                .conDocumentoIdentidad("123456789")
                .reconstruir();
        Assertions.assertFalse(cliente.esMembresiaEsmeralda());
        Assertions.assertTrue(cliente.esMembresiaRuby());
    }
}
