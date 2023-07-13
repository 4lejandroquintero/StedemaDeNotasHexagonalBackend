package cine.boleto;
import cine.boleto.entidad.Boleto;
import cine.funcion.FuncionTestDataBuilder;
import cine.funcion.modelo.entidad.Funcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class BoletoTest {
    @Test
    void deberiaCrearBoletoCorrectamente(){
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(funcion).reconstruir();

        Assertions.assertEquals(1L, boleto.getIdBoleto());
        Assertions.assertEquals(5, boleto.getCantidadAsientos());
        Assertions.assertEquals("A4,A5,B4,B5,B6", boleto.getNumeroAsientos());
        Assertions.assertEquals(funcion, boleto.getFuncion());
    }
}






