package sistemaNotas.examen;

import sistemaNotas.core.BasePrueba;
import sistemaNotas.dominio.excepcion.ExcepcionValorObligatorio;
import sistemaNotas.examen.modelo.entidad.Examen;
import sistemaNotas.pregunta.PreguntaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sistemaNotas.pregunta.modelo.entidad.Pregunta;


class ExamenTest {
    @Test
    void deberiaCrearExamenCorrectamente(){
        Pregunta pregunta = new PreguntaTestDataBuilder().crearPreguntaPorDefecto().reconstruir();
        Examen examen = new ExamenTestDataBuilder().crearExamenPorDefecto().conPregunta(pregunta).crear();

        Assertions.assertEquals(pregunta, examen.getPregunta());
        Assertions.assertEquals("Ciencias Naturales", examen.getTitulo());
        Assertions.assertEquals("Para Aprender", examen.getDescripcion());
        Assertions.assertEquals("8", examen.getPuntosMaximos());
        Assertions.assertEquals("10", examen.getNumeroDePreguntas());
        Assertions.assertEquals(true, examen.isActivo());
    }
    @Test
    void crearExamenSinPreguntaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conPregunta(null).crear(),
                ExcepcionValorObligatorio.class, "La pregunta es requerida para crear un examen");
    }
    @Test
    void crearExamenSinTituloDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conTitulo(null).crear(),
                ExcepcionValorObligatorio.class, "El titulo es requerido");
    }
    @Test
    void crearFuncionSinDescripcionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conDescripcion(null).crear(),
                ExcepcionValorObligatorio.class, "La descripcion es requerida");
    }
    @Test
    void crearFuncionSinPuntosMaximosDeberiaGenerarExcepcion() {
        BasePrueba.assertThrows(() -> new ExamenTestDataBuilder().crearExamenPorDefecto().conPuntosMaximos(null).crear(),
                ExcepcionValorObligatorio.class, "Los puntos máximos son requeridos");
    }
    @Test
    void crearFuncionSinNumeroDePreguntasDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conNumeroDePreguntas(null).crear(),
                ExcepcionValorObligatorio.class, "El número de preguntas es requerido");
    }
    @Test
    void crearFuncionSinActivoTrueDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().isActivo(true).crear(),
                ExcepcionValorObligatorio.class, "El estado es requerido");
    }

    @Test
    void deberiaReconstruirExamenCorrectamente(){
        Pregunta pregunta = new PreguntaTestDataBuilder().crearPreguntaPorDefecto().reconstruir();
        Examen examen = new ExamenTestDataBuilder().crearExamenPorDefecto().conPregunta(pregunta).reconstruir();

        Assertions.assertEquals(1L, examen.getExamenId());
        Assertions.assertEquals(pregunta, examen.getPregunta());
        Assertions.assertEquals("Ciencias Naturales", examen.getTitulo());
        Assertions.assertEquals("Para aprender", examen.getDescripcion());
        Assertions.assertEquals("8", examen.getPuntosMaximos());
        Assertions.assertEquals("10", examen.getNumeroDePreguntas());
        Assertions.assertEquals(true, examen.isActivo());
    }
    @Test
    void reconstruirExamenSinIDPreguntalaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conIdExamen(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El id del examen es requerido");
    }
    @Test
    void reconstruirExamenSinPreguntaDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conPregunta(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Es necesario ingresar la pregunta, es requerido");
    }
    @Test
    void reconstruirExamenSinTituloDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conTitulo(null).reconstruir(),
                ExcepcionValorObligatorio.class, "El titulo es requerido");
    }
    @Test
    void reconstruirExamenSinDescripcionDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conDescripcion(null).reconstruir(),
                ExcepcionValorObligatorio.class, "La descripción es requerida");
    }
    @Test
    void reconstruirExamenSinPuntosMaximosDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conPuntosMaximos(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Puntos Maximos es requerido");
    }
    @Test
    void reconstruirExamenSinNumeroDePreguntasDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().conNumeroDePreguntas(null).reconstruir(),
                ExcepcionValorObligatorio.class, "Numero de preguntas es requerido");
    }
    @Test
    void reconstruirExamenSinEstadoActivoDeberiaGenerarExcepcion(){
        BasePrueba.assertThrows(()-> new ExamenTestDataBuilder().crearExamenPorDefecto().isActivo(true).reconstruir(),
                ExcepcionValorObligatorio.class, "El estado activo es requerido");
    }
}
