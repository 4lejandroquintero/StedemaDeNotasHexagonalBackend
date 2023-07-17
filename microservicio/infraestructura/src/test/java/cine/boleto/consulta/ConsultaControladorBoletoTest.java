package cine.boleto.consulta;

import cine.ApplicationMock;
import cine.boleto.controlador.ConsultaControladorBoleto;
import cine.cliente.controlador.ComandoControladorCliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorBoleto.class)
@ContextConfiguration(classes = ApplicationMock.class)
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorBoletoTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void seObtieneListadodeBoletosPorFuncion() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/boleto/funcion/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void seObtieneBoletoPorID() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/boleto/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

}
