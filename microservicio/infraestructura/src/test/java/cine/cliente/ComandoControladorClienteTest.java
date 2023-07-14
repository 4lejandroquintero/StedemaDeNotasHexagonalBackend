package cine.cliente;

import cine.ApplicationMock;
import cine.cliente.comando.ComandoSolicitudCrearCliente;
import cine.cliente.controlador.ComandoControladorCliente;
import cine.cliente.modelo.entidad.Membresia;
import cine.cliente.puerto.RepositorioCliente;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    private RepositorioCliente repositorioCliente;

    @Test
    void crearClienteExitoso() throws Exception {
        var comandoSolicitudCrearCliente = new ComandoControladorClienteTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/cine/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearCliente)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearCliente.class);

        var clienteGuardado = repositorioCliente.obtener(respuesta.getValor());

        Assertions.assertEquals(1L, clienteGuardado.getIdCliente());
        Assertions.assertEquals("Cliente 1", clienteGuardado.getNombre());
        Assertions.assertEquals("cliente@mail.com", clienteGuardado.getEmail());
        Assertions.assertEquals("admin", clienteGuardado.getContrasena());
        Assertions.assertEquals("123456789", clienteGuardado.getDocumentoIdentidad());
        Assertions.assertEquals(Membresia.ZAFIRO, clienteGuardado.getTipoMembresia());
    }
}
