package cine.factura;

import cine.boleto.BoletoTestDataBuilder;
import cine.boleto.entidad.Boleto;
import cine.cliente.ClienteTestDataBuilder;
import cine.cliente.modelo.entidad.Cliente;
import cine.factura.modelo.dto.ResumenFacturaDTO;
import cine.factura.modelo.entidad.Factura;
import cine.factura.modelo.entidad.SolicitudFacturar;

public class SolicitudFacturarTestDataBuilder {
    private Cliente cliente;
    private Boleto boleto;

    public SolicitudFacturarTestDataBuilder  () {
        this.cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        this.boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
    }

    public SolicitudFacturarTestDataBuilder  solicitudFacturarTestPorDefecto() {
        this.cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
        this.boleto = new BoletoTestDataBuilder().conBoletoPorDefecto().reconstruir();
        return this;
    }

    public SolicitudFacturarTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public SolicitudFacturarTestDataBuilder conBoleto(Boleto boleto) {
        this.boleto = boleto;
        return this;
    }
    public Factura crearSinBoleto(){
        return Factura.crear(solicitudFacturarTestPorDefecto().conBoleto(null).construir());
    }

    public Factura crearSinCliente(){
        return Factura.crear(solicitudFacturarTestPorDefecto().conCliente(null).construir());
    }


    public SolicitudFacturar construir(){
        return new SolicitudFacturar(cliente, boleto);
    }


}
