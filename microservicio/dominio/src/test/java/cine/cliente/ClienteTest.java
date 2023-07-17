package cine.cliente;


import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
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
        Assertions.assertEquals(Membresia.RUBY, cliente.getTipoMembresia());
    }
    @Test
    void deberiaCrearClienteExitosoConContrasena(){

        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().crearConContrasena();

        Assertions.assertEquals(1L, cliente.getIdCliente());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("admin", cliente.getContrasena());
        Assertions.assertEquals("cliente@mail.com", cliente.getEmail());
        Assertions.assertEquals("123456789", cliente.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.RUBY, cliente.getTipoMembresia());
    }
    @Test
    void deberiaConstruirCliente(){

        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().crear();

        Assertions.assertEquals(1L, cliente.getIdCliente());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("123456789", cliente.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.RUBY, cliente.getTipoMembresia());
    }

    @Test
    void crearClienteSinTipoDeberiaLanzarError(){
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
    void crearClienteSinEmailDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                        .conId(1L)
                        .conNombre("Cliente 1")
                        .conContrasena("admin")
                        .conDocumentoIdentidad("123456789")
                        .conTipoMembresia(Membresia.ESMERALDA).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el email del cliente");
    }


    @Test
    void crearClienteSinNombreDeberiaLanzarError(){
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
    void crearClienteSinIdDeberiaLanzarError(){
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
    void reconstruirClienteSinIdDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                        .conId(null)
                        .conNombre("Cliente 1")
                        .conEmail("cliente@mail.com")
                        .conContrasena("admin")
                        .conDocumentoIdentidad("123456789")
                        .conTipoMembresia(Membresia.ZAFIRO).crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el id del cliente");
    }

    @Test
    void crearClienteSinDocumentoIdentidadDeberiaLanzarError(){
        BasePrueba.assertThrows(()-> new ClienteTestDataBuilder().conClientePorDefecto().conDocumentoIdentidad(null).reconstruir(),ExcepcionValorObligatorio.class
                ,"Es necesario ingresar el documento de identidad del cliente");
    }

    @Test
    void deberiaResponderEsClienteMembersiaZafiroCorrectamente(){
        var cliente = new ClienteTestDataBuilder().conClientePorDefecto()
                .conTipoMembresia(Membresia.ZAFIRO).reconstruir();

        Assertions.assertTrue(cliente.esMembresiaZafiro());
        Assertions.assertFalse(cliente.esMembresiaEsmeralda());
        Assertions.assertFalse(cliente.esMembresiaRuby());
    }

    @Test
    void deberiaResponderEsClienteMembresiaRubyCorrectamente(){
        var cliente = new ClienteTestDataBuilder().conClientePorDefecto()
                .conTipoMembresia(Membresia.RUBY)
                .reconstruir();
        Assertions.assertTrue(cliente.esMembresiaRuby());
        Assertions.assertFalse(cliente.esMembresiaEsmeralda());
        Assertions.assertFalse(cliente.esMembresiaZafiro());
    }
    @Test
    void deberiaResponderEsClienteMembresiaEsmeraldaCorrectamente(){
        var cliente = new ClienteTestDataBuilder().conClientePorDefecto()
                .conTipoMembresia(Membresia.ESMERALDA)
                .reconstruir();
        Assertions.assertTrue(cliente.esMembresiaEsmeralda());
        Assertions.assertFalse(cliente.esMembresiaRuby());
        Assertions.assertFalse(cliente.esMembresiaZafiro());
    }
    @Test
    void reconstruirClienteSinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                        .conId(1L)
                        .conEmail("cliente@mail.com")
                        .conContrasena("admin")
                        .conDocumentoIdentidad("123456789")
                        .conTipoMembresia(Membresia.ZAFIRO).crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el nombre del cliente");
    }
    @Test
    void reconstruirClienteSinTipoDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ClienteTestDataBuilder()
                        .conId(1L)
                        .conNombre("Cliente 1")
                        .conEmail("cliente@mail.com")
                        .conContrasena("admin")
                        .conDocumentoIdentidad("123456789").crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el tipo de membresia del cliente");
    }

    @Test
    void reconstruirClienteSinDocumentoIdentidadDeberiaLanzarError(){
        BasePrueba.assertThrows(()-> new ClienteTestDataBuilder().conClientePorDefecto().conDocumentoIdentidad(null).crear(),ExcepcionValorObligatorio.class
        ,"Es necesario ingresar el documento de identidad del cliente");
    }




    @Test
    void generarCienteDatosPrincipales(){
        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        var clienteDTO = new ClienteDatosPrincipalesDTO(cliente.getIdCliente(),cliente.getNombre(),cliente.getDocumentoIdentidad(),cliente.getTipoMembresia());

        Assertions.assertEquals(cliente.getIdCliente(),clienteDTO.getId());
        Assertions.assertEquals(cliente.getNombre(),clienteDTO.getNombre());
        Assertions.assertEquals(cliente.getDocumentoIdentidad(),clienteDTO.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.RUBY,clienteDTO.getTipoMembresia());
    }

    @Test
    void crearClienteConContrasena(){
        var cliente = new ClienteTestDataBuilder().conClientePorDefecto().crearConContrasena();
        Assertions.assertEquals(1L, cliente.getIdCliente());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("cliente@mail.com", cliente.getEmail());
        Assertions.assertEquals("123456789", cliente.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.RUBY, cliente.getTipoMembresia());
        Assertions.assertEquals("admin", cliente.getContrasena());
    }
}
