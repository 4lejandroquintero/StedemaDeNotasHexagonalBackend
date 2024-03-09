package sistemaNotas.usuario;

import sistemaNotas.core.BasePrueba;
import sistemaNotas.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.usuario.modelo.entidad.Rol;

class UsuarioTest {
    @Test
    void deberiaCrearUsuarioExitoso(){

        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder().conUsuarioPorDefecto().reconstruir();

        Assertions.assertEquals(1L, usuario.getId());
        Assertions.assertEquals("Cliente 1", usuario.getUsername());
        Assertions.assertEquals("Cliente 1", usuario.getPassword());
        Assertions.assertEquals("Cliente 1", usuario.getNombre());
        Assertions.assertEquals("Cliente 1", usuario.getApellido());
        Assertions.assertEquals("cliente@mail.com", usuario.getEmail());
        Assertions.assertEquals("cliente@mail.com", usuario.getTelefono());
        Assertions.assertEquals(true, usuario.isEnabled());
        Assertions.assertEquals(Rol.NORMAL, usuario.getRol());
    }
    @Test
    void deberiaCrearUsuarioExitosoConContrasena(){

        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder().conUsuarioPorDefecto().reconstruir();

        Assertions.assertEquals(1L, usuario.getId());
        Assertions.assertEquals("Cliente 1", usuario.getUsername());
        Assertions.assertEquals("Cliente 1", usuario.getPassword());
        Assertions.assertEquals("Cliente 1", usuario.getNombre());
        Assertions.assertEquals("Cliente 1", usuario.getApellido());
        Assertions.assertEquals("cliente@mail.com", usuario.getEmail());
        Assertions.assertEquals("cliente@mail.com", usuario.getTelefono());
        Assertions.assertEquals(true, usuario.isEnabled());
        Assertions.assertEquals(Rol.NORMAL, usuario.getRol());
    }
    @Test
    void deberiaConstruirUsuario(){

        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder().conUsuarioPorDefecto().reconstruir();

        Assertions.assertEquals(1L, usuario.getId());
        Assertions.assertEquals("Cliente 1", usuario.getUsername());
        Assertions.assertEquals("123456789", usuario.getPassword());
        Assertions.assertEquals(Rol.NORMAL, usuario.getRol());
    }

    @Test
    void crearClienteSinRolDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                .conId(1L)
                .conUsername("alejoq96")
                .conPassword("12345")
                .conEmail("cliente@mail.com")
                .conRol(Rol.NORMAL).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el tipo de membresia del cliente");
    }
    @Test
    void crearClienteSinEmailDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                        .conId(1L)
                        .conUsername("alejoq96")
                        .conPassword("12345")
                        .conEmail("cliente@mail.com")
                        .conRol(Rol.NORMAL).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el email del cliente");
    }


    @Test
    void crearClienteSinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                        .conId(1L)
                        .conUsername("alejoq96")
                        .conPassword("12345")
                        .conEmail("cliente@mail.com")
                        .conRol(Rol.NORMAL).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el nombre del cliente");
    }

    @Test
    void crearClienteSinIdDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                .conId(null)
                .conNombre("Cliente 1")
                .conEmail("cliente@mail.com")
                .conPassword("admin")
                .conUsername("123456789")
                .conRol(Rol.NORMAL).reconstruir(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el id del cliente");
    }

    @Test
    void reconstruirUsuarioSinIdDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                        .conId(null)
                        .conNombre("Cliente 1")
                        .conEmail("cliente@mail.com")
                        .conPassword("admin")
                        .conUsername("123456789")
                        .conRol(Rol.NORMAL).crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el id del cliente");
    }

    @Test
    void crearUsuarioSinTelefonoDeberiaLanzarError(){
        BasePrueba.assertThrows(()-> new UsuarioTestDataBuilder().conUsuarioPorDefecto().conTelefono(null).reconstruir(),ExcepcionValorObligatorio.class
                ,"Es necesario ingresar el documento de identidad del cliente");
    }

    @Test
    void deberiaResponderEsUsuarioRolNormalCorrectamente(){
        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder()
                .conRol(Rol.NORMAL).reconstruir();

        Assertions.assertTrue(usuario.esPerfilAdmin());
        Assertions.assertFalse(usuario.esPerfilNormal());
    }

    @Test
    void deberiaResponderEsUsuarioRolAdminCorrectamente() {
        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder()
                .conRol(Rol.ADMIN).reconstruir();
        Assertions.assertTrue(usuario.esPerfilAdmin());
        Assertions.assertFalse(usuario.esPerfilNormal());
    }
    @Test
    void reconstruirUsuarioSinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                        .conId(1L)
                        .conEmail("cliente@mail.com")
                        .conPassword("admin")
                        .conEmail("123456789")
                        .conRol(Rol.NORMAL).crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el nombre del usuario");
    }
    @Test
    void reconstruirUsuarioSinRolDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new UsuarioTestDataBuilder()
                        .conId(1L)
                        .conNombre("Cliente 1")
                        .conEmail("cliente@mail.com")
                        .conPassword("admin")
                        .conEmail("123456789").crear(),
                ExcepcionValorObligatorio.class,
                "Es necesario ingresar el tipo de membresia del cliente");
    }

    @Test
    void reconstruirUsuarioSinTelefonoDeberiaLanzarError(){
        BasePrueba.assertThrows(()-> new UsuarioTestDataBuilder().conUsuarioPorDefecto().conTelefono(null).crear(),ExcepcionValorObligatorio.class
        ,"Es necesario ingresar el telefono del usuario");
    }




    @Test
    void generarUsuarioDatosPrincipales(){
        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder().conUsuarioPorDefecto().reconstruir();
        UsuarioDatosPrincipalesDTO usuarioDTO = new UsuarioDatosPrincipalesDTO(usuario.getId(),usuario.getUsername(),usuario.getPassword(),Rol.NORMAL);

        Assertions.assertEquals(usuario.getId(),usuarioDTO.getId());
        Assertions.assertEquals(usuario.getUsername(),usuarioDTO.getUsername());
        Assertions.assertEquals(usuario.getPassword(),usuarioDTO.getPassword());
        Assertions.assertEquals(Rol.NORMAL,usuarioDTO.getTipoRol());
    }

    @Test
    void crearClienteConContrasena(){
        sistemaNotas.usuario.modelo.entidad.Usuario usuario = new UsuarioTestDataBuilder().conUsuarioPorDefecto().crearConContrasena();
        Assertions.assertEquals(1L, usuario.getId());
        Assertions.assertEquals("Cliente 1", usuario.getUsername());
        Assertions.assertEquals("cliente@mail.com", usuario.getPassword());
        Assertions.assertEquals("123456789", usuario.getNombre());
        Assertions.assertEquals("123456789", usuario.getApellido());
        Assertions.assertEquals("123456789", usuario.getEmail());
        Assertions.assertEquals("123456789", usuario.getTelefono());
        Assertions.assertEquals(true, usuario.isEnabled());
        Assertions.assertEquals(Rol.NORMAL, usuario.getRol());
    }
}
