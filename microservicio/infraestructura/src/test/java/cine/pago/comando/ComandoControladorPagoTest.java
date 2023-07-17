package cine.pago.comando;

import cine.ApplicationMock;
import cine.cliente.RespuestaCreacion;
import cine.funcion.controlador.ComandoControladorFuncion;
import cine.infraestructura.excepcion.ExcepcionTecnica;
import cine.pago.entidad.Pago;
import cine.pago.puerto.RepositorioPago;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFuncion.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorPagoTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RepositorioPago repositorioPago;

    @Test
    void seRealizaPagoDeFacturaCorrectamente() throws Exception {
        var comandoRealizarPago = new ComandoControladorPagoTestDataBuilder().comandoPagoPorDefecto().construir();

        MvcResult resultado = mockMvc.perform(post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoRealizarPago)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Pago pagoRealizado = repositorioPago.obtener(respuesta.getValor());

        Assertions.assertEquals(2L, pagoRealizado.getIdPago());
        Assertions.assertEquals(2L, pagoRealizado.getFactura().getIdFactura());
        Assertions.assertEquals(BigDecimal.valueOf(40000), pagoRealizado.getValorAPagar().setScale(0, RoundingMode.DOWN));
        Assertions.assertEquals(BigDecimal.valueOf(10750), pagoRealizado.getDevuelta().setScale(0, RoundingMode.DOWN));
    }

    @Test
    void seRealizaPagoDeFacturaConValorMenorDeValorFacturaDeberiaLanzarExcepcion() throws Exception {
        BigDecimal valorAPagarMenor = new BigDecimal(25000);
        var comandoRealizarPago = new ComandoControladorPagoTestDataBuilder().comandoPagoPorDefecto().conValorAPagar(valorAPagarMenor).construir();

        MvcResult resultado = mockMvc.perform(post("/pagos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoRealizarPago)))
                .andExpect(status().isBadRequest()).andReturn();

    }

}
