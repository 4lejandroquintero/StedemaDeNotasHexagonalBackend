package sistemaNotas.categoria.comando;

import sistemaNotas.ApplicationMock;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.categoria.puerto.CategoriaRepositorio;
import sistemaNotas.usuario.RespuestaCreacion;
import sistemaNotas.usuario.controlador.ComandoControladorUsuario;
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
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorCategoriaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void crearBoletoExitoso() throws Exception {
        var comandoSolicitudCrearCategoria  = new ComandoControladorCategoriaTestDataBuilder().crearPorDefecto().construir();

        MvcResult resultado = mocMvc.perform(post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoSolicitudCrearCategoria)))
                .andExpect(status().isCreated()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCreacion.class);

        Categoria categoriaGuardada = categoriaRepositorio.obtener(respuesta.getValor());

        Assertions.assertEquals(3L, categoriaGuardada.getCategoriaId());
        Assertions.assertEquals(4, categoriaGuardada.getTitulo());
        Assertions.assertEquals("A1,A2,B1,B2", categoriaGuardada.getDescripcion());
        Assertions.assertEquals(2L, categoriaGuardada.getExamen().getExamenId());

    }
}
