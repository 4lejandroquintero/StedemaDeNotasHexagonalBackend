package sistemaNotas.pregunta.comando;

import sistemaNotas.ApplicationMock;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;
import sistemaNotas.usuario.RespuestaCreacion;
import sistemaNotas.pregunta.controlador.ComandoControladorPregunta;
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
@WebMvcTest(ComandoControladorPregunta.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorPreguntaTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    @Test
    void crearPreguntaExitosamente() throws Exception {
        var comandoSolicitudCrearPelicula = new ComandoControladorPreguntaTestDataBuilder().conPreguntaPorDefecto().construir();
        MvcResult resultado = mockMvc.perform(post("/pregunta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearPelicula)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        var pregunta = preguntaRepositorio.obtener(respuesta.getValor());

        Assertions.assertEquals(2L, pregunta.getPreguntaId());
        Assertions.assertEquals("Ant Man", pregunta.getContenido());
        Assertions.assertEquals("Pelicula de Superheroes", pregunta.getImagen());
        Assertions.assertEquals("urlImagen", pregunta.getOpcion1());
        Assertions.assertEquals("+12", pregunta.getOpcion2());
        Assertions.assertEquals("+12", pregunta.getOpcion3());
        Assertions.assertEquals("+12", pregunta.getOpcion4());
        Assertions.assertEquals("+12", pregunta.getRespuestaDada());
        Assertions.assertEquals("+12", pregunta.getRespuesta());
    }

}
