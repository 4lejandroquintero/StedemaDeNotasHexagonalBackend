package cine.funcion.consulta;

import cine.ApplicationMock;
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
@WebMvcTest(ComandoControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorFuncionTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void seObtienenListadoDeFunciones() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/funcion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    void seObtieneFuncionPorID() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/funcion/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

}
