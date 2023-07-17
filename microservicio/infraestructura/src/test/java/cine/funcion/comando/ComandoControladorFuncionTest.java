package cine.funcion.comando;

import cine.ApplicationMock;
import cine.cliente.RespuestaCreacion;
import cine.funcion.controlador.ComandoControladorFuncion;
import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.RepositorioFuncion;
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

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFuncion.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorFuncionTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioFuncion repositorioFuncion;

    @Test
    void crearFuncionExitosa() throws Exception {

        ComandoCrearFuncion comandoCrearFuncion = new ComandoControladorFuncionTestDataBuilder().funcionPorDefecto().construir();


        MvcResult resultado = mocMvc.perform(post("/funcion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearFuncion)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Funcion funcion = repositorioFuncion.obtener(respuesta.getValor());

        Assertions.assertEquals(1L, funcion.getPelicula().getIdPelicula());
        Assertions.assertEquals("Cinepolis", funcion.getNombreTeatro());
        Assertions.assertEquals("Q1", funcion.getSalaFuncion());
        Assertions.assertEquals(LocalDate.of(2023,6,30), funcion.getDiaFuncion());
        Assertions.assertEquals(LocalTime.of(8,30), funcion.getHoraFuncion());
        Assertions.assertEquals("Doblaje Latino", funcion.getCategoriaAudioFuncion());
        Assertions.assertEquals("Sin Subtitulos", funcion.getCategoriaSubtitulosFuncion());
        Assertions.assertEquals("2D", funcion.getCategoriaVisualFuncion());
    }
}
