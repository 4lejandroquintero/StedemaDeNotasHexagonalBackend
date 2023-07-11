package cine.cliente;

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
@WebMvcTest(ComandoControladorClienteTest.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    @Autowired
    private RepositorioCliente repositorioCliente;

    @Test
    void crearFacturaExitosa() throws Exception {
        var comandoCrearClienteTestDataBuilder = new ComandoControladorClienteTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearClienteTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearCliente.class);

        var clienteGuardado = repositorioCliente.obtener(respuesta.getValor());

        /*Assertions.assertEquals("Cliente 1", clienteGuardado.getIdCliente().getNombre());
        Assertions.assertEquals(175000l, clienteGuardado.get().longValue());
        Assertions.assertEquals(2, clienteGuardado.getProductos().size());*/
    }
}
