package cine.cliente.comando;

import cine.ApplicationMock;
import cine.cliente.controlador.ComandoControladorCliente;
import cine.cliente.modelo.entidad.Cliente;
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
import org.springframework.test.web.servlet.MvcResult;

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


    @Autowired
    private RepositorioCliente repositorioCliente;

    @Test
    void crearClienteExitoso() throws Exception {
        var comandoSolicitudCrearCliente = new ComandoControladorClienteTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearCliente)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearCliente.class);

        Cliente clienteGuardado = repositorioCliente.obtener(respuesta.getValor());

        Assertions.assertEquals(3L, clienteGuardado.getIdCliente());
        Assertions.assertEquals("Cliente 1", clienteGuardado.getNombre());
        Assertions.assertEquals(Membresia.ZAFIRO, clienteGuardado.getTipoMembresia());
    }
}
