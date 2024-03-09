package sistemaNotas.categoria;
import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.core.BasePrueba;
import sistemaNotas.dominio.excepcion.ExcepcionValorObligatorio;
import sistemaNotas.examen.ExamenTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sistemaNotas.examen.modelo.entidad.Examen;

class CategoriaTest {
    @Test
    void deberiaCrearCategoriaCorrectamente(){
        Examen examen = new ExamenTestDataBuilder().crearExamenPorDefecto().reconstruir();
        Categoria categoria = new CategoriaTestDataBuilder().conCategoriaPorDefecto().conExamen(examen).reconstruir();

        Assertions.assertEquals(1L, categoria.getCategoriaId());
        Assertions.assertEquals("Ciencias Naturales", categoria.getTitulo());
        Assertions.assertEquals("Aprende sobre las ciencias", categoria.getDescripcion());
        Assertions.assertEquals(examen, categoria.getExamen());
    }

    @Test
    void reconstruirCategoriaSinCategoriaIdDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conCategoriaId(null).reconstruir()
        , ExcepcionValorObligatorio.class,"El id de la categoria debe ser ingresado");
    }
    @Test
    void reconstruirCategoriaSinTituloDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conTitulo(null).reconstruir()
                , ExcepcionValorObligatorio.class,"Debe ingresar el titulo");
    }
    @Test
    void reconstruirCategoriaSinDescripcionDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conDescripcion(null).reconstruir()
                , ExcepcionValorObligatorio.class,"El boleto debe de contar con un numero de asiento");
    }
    @Test
    void reconstruirCategoriaSinExamenDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conExamen(null).reconstruir()
                , ExcepcionValorObligatorio.class,"Debe tener una función dada para el boleto");
    }

    //-----------------------------------------------------------------------------------------------------------------//

    @Test
    void crearCategoriaSinTituloDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conTitulo(null).crear()
        ,ExcepcionValorObligatorio.class, "Debe ingresar la cantidad de asientos");
    }
    @Test
    void crearCategoriaSinDescripcionDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conDescripcion(null).crear()
                ,ExcepcionValorObligatorio.class, "El boleto debe de contar con un numero de asiento");
    }
    @Test
    void crearCategoriaSinExamenDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new CategoriaTestDataBuilder().conCategoriaPorDefecto().conExamen(null).crear()
                ,ExcepcionValorObligatorio.class, "Debe tener una función dada para el boleto");
    }
    @Test
    void crearCategoriaCorrectamente(){
        Examen examen = new ExamenTestDataBuilder().crearExamenPorDefecto().reconstruir();
        Categoria categoria = new CategoriaTestDataBuilder().conCategoriaPorDefecto().conExamen(examen).crear();

        Assertions.assertEquals("Ciencias Naturales", categoria.getTitulo());
        Assertions.assertEquals("Aprende sobre las ciencias", categoria.getDescripcion());
        Assertions.assertEquals(examen, categoria.getExamen());
    }


}






