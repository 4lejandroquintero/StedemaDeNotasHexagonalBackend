package cine.boleto;
import cine.boleto.entidad.Boleto;
import cine.core.BasePrueba;
import cine.dominio.excepcion.ExcepcionValorObligatorio;
import cine.funcion.FuncionTestDataBuilder;
import cine.funcion.modelo.entidad.Funcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BoletoTest {
    @Test
    void deberiaCrearBoletoCorrectamente(){
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(funcion).reconstruir();

        Assertions.assertEquals(1L, boleto.getIdBoleto());
        Assertions.assertEquals(5, boleto.getCantidadAsientos());
        Assertions.assertEquals("A4,A5,B4,B5,B6", boleto.getNumeroAsientos());
        Assertions.assertEquals(LocalDate.of(2023,3,12), boleto.obtenerFechaFuncion());
        Assertions.assertEquals(funcion, boleto.getFuncion());
    }

    @Test
    void reconstruirBoletoSinIdDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conIdBoleto(null).reconstruir()
        , ExcepcionValorObligatorio.class,"El id del boleto debe ser ingresado");
    }
    @Test
    void reconstruirBoletoSinCantidadAsientosDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conCantidadAsientos(null).reconstruir()
                , ExcepcionValorObligatorio.class,"Debe ingresar la cantidad de asientos");
    }
    @Test
    void reconstruirBoletoSinNumeroDeAsientosDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conNumeroAsientos(null).reconstruir()
                , ExcepcionValorObligatorio.class,"El boleto debe de contar con un numero de asiento");
    }
    @Test
    void reconstruirBoletoSinFuncionDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(null).reconstruir()
                , ExcepcionValorObligatorio.class,"Debe tener una función dada para el boleto");
    }

    //-----------------------------------------------------------------------------------------------------------------//

    @Test
    void crearBoletoSinCantidadAsientosDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conCantidadAsientos(null).crear()
        ,ExcepcionValorObligatorio.class, "Debe ingresar la cantidad de asientos");
    }
    @Test
    void crearBoletoSinNumeroDeAsientosDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conNumeroAsientos(null).crear()
                ,ExcepcionValorObligatorio.class, "El boleto debe de contar con un numero de asiento");
    }
    @Test
    void crearBoletoSinFuncionDeberiaSalirExcepcion(){
        BasePrueba.assertThrows(()-> new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(null).crear()
                ,ExcepcionValorObligatorio.class, "Debe tener una función dada para el boleto");
    }
    @Test
    void crearBoletoCorrectamente(){
        Funcion funcion = new FuncionTestDataBuilder().crearFuncionPorDefecto().reconstruir();
        Boleto boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().conFuncion(funcion).crear();

        Assertions.assertEquals(5, boleto.getCantidadAsientos());
        Assertions.assertEquals("A4,A5,B4,B5,B6", boleto.getNumeroAsientos());
        Assertions.assertEquals(funcion, boleto.getFuncion());
    }


}






