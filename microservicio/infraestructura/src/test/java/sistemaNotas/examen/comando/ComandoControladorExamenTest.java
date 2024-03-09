package sistemaNotas.examen.comando;

import sistemaNotas.ApplicationMock;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.usuario.RespuestaCreacion;
import sistemaNotas.examen.controlador.ComandoControladorExamen;
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
@WebMvcTest(ComandoControladorExamen.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorExamenTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    ExamenRepositorio examenRepositorio;

    @Test
    void crearFuncionExitosa() throws Exception {

        ComandoCrearExamen comandoCrearExamen = new ComandoControladorExamenTestDataBuilder().examenPorDefecto().construir();


        MvcResult resultado = mocMvc.perform(post("/examen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearExamen)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Examen examen = examenRepositorio.obtener(respuesta.getValor());

        Assertions.assertEquals(1L, examen.getPregunta().getPreguntaId());
        Assertions.assertEquals("Cuerpo Humano", examen.getTitulo());
        Assertions.assertEquals("Conoce tu cuerpo humano", examen.getDescripcion());
        Assertions.assertEquals("10", examen.getPuntosMaximos());
        Assertions.assertEquals("8", examen.getNumeroDePreguntas());
        Assertions.assertEquals(true, examen.isActivo());
    }
}
