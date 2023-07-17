package cine.boleto.comando;


import cine.ApplicationMock;
import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.RepositorioBoleto;
import cine.cliente.RespuestaCreacion;
import cine.cliente.controlador.ComandoControladorCliente;
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
class ComandoControladorBoletoTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioBoleto repositorioBoleto;

    @Test
    void crearBoletoExitoso() throws Exception {
        var comandoSolicitudCrearBoleto  = new ComandoControladorBoletoTestDataBuilder().crearPorDefecto().construir();

        MvcResult resultado = mocMvc.perform(post("/boleto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearBoleto)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Boleto boletoGuardado = repositorioBoleto.obtener(respuesta.getValor());

        Assertions.assertEquals(3L, boletoGuardado.getIdBoleto());
        Assertions.assertEquals(4, boletoGuardado.getCantidadAsientos());
        Assertions.assertEquals("A1,A2,B1,B2", boletoGuardado.getNumeroAsientos());
        Assertions.assertEquals(2L, boletoGuardado.getFuncion().getIdFuncion());

    }
}
