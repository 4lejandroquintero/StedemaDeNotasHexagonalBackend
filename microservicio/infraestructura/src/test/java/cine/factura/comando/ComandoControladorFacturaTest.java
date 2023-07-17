package cine.factura.comando;

import cine.ApplicationMock;
import cine.cliente.RespuestaCreacion;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.funcion.comando.ComandoControladorFuncionTestDataBuilder;
import cine.funcion.comando.ComandoCrearFuncion;
import cine.funcion.controlador.ComandoControladorFuncion;
import cine.funcion.modelo.entidad.Funcion;
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
import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFuncion.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorFacturaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioFactura repositorioFactura;


    @Test
    void crearFacturaExitosa() throws Exception {

        var comandoSolicitudFacturar = new ComandoControladorFacturaTestDataBuilder().facturaPorDefecto().construir();


        MvcResult resultado = mocMvc.perform(post("/factura")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudFacturar)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Factura factura = repositorioFactura.obtener(respuesta.getValor());

        Assertions.assertEquals(3L, factura.getIdFactura());
        Assertions.assertEquals(2L, factura.getBoleto().getIdBoleto());
        Assertions.assertEquals(2L, factura.getCliente().getIdCliente());
        Assertions.assertEquals(LocalDate.now(), factura.getFechaFactura());
        Assertions.assertEquals(EstadoFactura.PENDIENTE, factura.getEstadoFactura());
        Assertions.assertEquals(BigDecimal.valueOf(45000), factura.getValorDeBoletos().setScale(0, RoundingMode.DOWN));
        Assertions.assertEquals(BigDecimal.valueOf(11250), factura.getDescuento().setScale(0, RoundingMode.DOWN));
        Assertions.assertEquals(BigDecimal.valueOf(33750), factura.getValorTotal().setScale(0, RoundingMode.DOWN));
    }
}
