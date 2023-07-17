package cine.boleto.comando;

import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.RepositorioBoleto;
import cine.funcion.puerto.RepositorioFuncion;

public class ComandoControladorBoletoTestDataBuilder {
    private Long idBoleto;
    private Integer cantidadAsientos;
    private String numeroAsientos;
    private Long idFuncion;
    public ComandoControladorBoletoTestDataBuilder crearPorDefecto() {
        this.idBoleto = 1L;
        this.cantidadAsientos = 4;
        this.numeroAsientos = "A1,A2" +
                              ",B1,B2";
        this.idFuncion = 2L;
        return this;
    }

    public ComandoSolicitudCrearBoleto construir() {
        return new ComandoSolicitudCrearBoleto(idBoleto,cantidadAsientos,numeroAsientos,idFuncion);
    }
}
