package cine.pelicula.comando;

import cine.ApplicationMock;
import cine.cliente.RespuestaCreacion;
import cine.cliente.comando.ComandoControladorClienteTestDataBuilder;
import cine.cliente.comando.RespuestaCrearCliente;
import cine.cliente.modelo.entidad.Cliente;
import cine.cliente.modelo.entidad.Membresia;
import cine.cliente.puerto.RepositorioCliente;
import cine.pelicula.controlador.ComandoControladorPelicula;
import cine.pelicula.puerto.RepositorioPelicula;
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
@WebMvcTest(ComandoControladorPelicula.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorPeliculaTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioPelicula repositorioPelicula;

    @Test
    void crearPeliculaExitosamente() throws Exception {
        var comandoSolicitudCrearPelicula = new ComandoControladorPeliculaTestDataBuilder().conPeliculaPorDefecto().construir();
        MvcResult resultado = mockMvc.perform(post("/pelicula")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearPelicula)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        var pelicula = repositorioPelicula.obtener(respuesta.getValor());

        Assertions.assertEquals(2L, pelicula.getIdPelicula());
        Assertions.assertEquals("Ant Man", pelicula.getNombrePelicula());
        Assertions.assertEquals("Pelicula de Superheroes", pelicula.getSinopsisPelicula());
        Assertions.assertEquals("urlImagen", pelicula.getImagenPortada());
        Assertions.assertEquals("+12", pelicula.getCategoriaEdadPelicula());
    }

}
