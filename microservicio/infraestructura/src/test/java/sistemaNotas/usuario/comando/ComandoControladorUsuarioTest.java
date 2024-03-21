package sistemaNotas.usuario.comando;

import sistemaNotas.ApplicationMock;
import sistemaNotas.usuario.controlador.ComandoControladorUsuario;
import sistemaNotas.usuario.modelo.entidad.Rol;
import sistemaNotas.usuario.modelo.entidad.Usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import sistemaNotas.usuario.puerto.UsuarioRepositorio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorUsuarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    void crearUsuarioExitoso() throws Exception {
        ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario = new ComandoControladorUsuarioTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearUsuario)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        RespuestaCrearUsuario respuesta = objectMapper.readValue(jsonResult, RespuestaCrearUsuario.class);

        Usuario usuarioGuardado = usuarioRepositorio.obtener(respuesta.getValor());

        Assertions.assertEquals(1L, usuarioGuardado.getId());
        Assertions.assertEquals("alejoq96", usuarioGuardado.getUsername());
        Assertions.assertEquals("Alejandro", usuarioGuardado.getNombre());
        Assertions.assertEquals(Rol.ADMIN, usuarioGuardado.getRol());
    }
}
