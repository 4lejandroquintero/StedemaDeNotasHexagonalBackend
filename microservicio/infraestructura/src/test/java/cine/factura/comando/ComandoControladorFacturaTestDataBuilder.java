package cine.factura.comando;

public class ComandoControladorFacturaTestDataBuilder {
    private Long idCliente;
    private Long idBoleto;

    public ComandoControladorFacturaTestDataBuilder facturaPorDefecto() {
        this.idCliente = 2L;
        this.idBoleto = 2L;
        return this;
    }

    public ComandoSolicitudFacturar construir(){
        return new ComandoSolicitudFacturar(idCliente, idBoleto);
    }

}
