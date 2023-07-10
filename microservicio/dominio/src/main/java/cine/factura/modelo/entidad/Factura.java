package cine.factura.modelo.entidad;

import cine.boleto.entidad.Boleto;
import cine.cliente.modelo.entidad.Cliente;
import cine.dominio.ValidadorArgumento;
import cine.dominio.excepcion.ExcepcionValorInvalido;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Long idFactura;
    private Boleto boleto;
    private Cliente cliente;
    private LocalDate fechaFactura;
    private EstadoFactura estadoFactura;
    private BigDecimal valorDeBoletos;
    private BigDecimal descuento;
    private BigDecimal valorTotal;

    public static final double DESCUENTO_MEMBRESIA_ESMERALDA = 0.15;
    public static final double DESCUENTO_MEMBRESIA_RUBY = 0.25;
    public static final double DESCUENTO_MEMBRESIA_ZAFIRO = 0.35;
    public static final double DESCUENTO_HAPPY_DAYS = 0.4;

    public Factura(Boleto boleto, Cliente cliente) {
        this.boleto = boleto;
        this.cliente = cliente;
        obtenerFecha();
        this.estadoFactura = EstadoFactura.PENDIENTE;
        this.valorDeBoletos = obtenerValorTodosBoletos(boleto);
        descuentosBoleto();
    }

    public Factura(Long idFactura, Boleto boleto, Cliente cliente, LocalDate fechaFactura, EstadoFactura estadoFactura, BigDecimal valorDeBoletos, BigDecimal descuento, BigDecimal valorTotal) {
        this.idFactura = idFactura;
        this.boleto = boleto;
        this.cliente = cliente;
        this.fechaFactura = fechaFactura;
        this.estadoFactura = estadoFactura;
        this.valorDeBoletos = valorDeBoletos;
        this.descuento = descuento;
        this.valorTotal = valorTotal;
    }
    public static Factura reconstruir(Long idFactura, Boleto boleto, Cliente cliente, LocalDate fechaFactura, EstadoFactura estadoFactura, BigDecimal valorDeBoletos, BigDecimal descuento, BigDecimal valorTotal){
        ValidadorArgumento.validarObligatorio(idFactura, "Se requiere una ID de Factura");
        ValidadorArgumento.validarObligatorio(boleto, "No se puede crear una factura sin boleto");
        ValidadorArgumento.validarObligatorio(cliente, "El cliente es necesario para generar factura");
        if(valorDeBoletos.compareTo(BigDecimal.ZERO) <= 0){
            throw new ExcepcionValorInvalido("El total no puede ser menor a cero");
        }
        return new Factura(idFactura, boleto, cliente, fechaFactura, estadoFactura, valorDeBoletos, descuento, valorTotal);
    }

    public static Factura crear(SolicitudFacturar solicitudFacturar){
        ValidadorArgumento.validarObligatorio(solicitudFacturar.getCliente(), "El cliente es requerido para generar una factura");
        ValidadorArgumento.validarObligatorio(solicitudFacturar.getBoleto(), "No se puede generar factura sin boletos.");
        return new Factura( solicitudFacturar.getBoleto(), solicitudFacturar.getCliente());
    }


    private BigDecimal obtenerValorTodosBoletos(Boleto boleto){
        //Obtengo el primer objeto de la lista de boletos para calcular el valor de la función la cual multiplicaré por la longitud de
        //la lista del objeto de boletos para tener saber el precio total de los boletos.
        //Multiplico el valor del primer boleto a la longitud de la lista de boletos.
        return boleto.obtenerValorFuncion().multiply(BigDecimal.valueOf(boleto.getCantidadAsientos()));
    }
    private void aplicarDescuentoDeMembresia(){
        if(this.cliente.esMembresiaEsmeralda()){
            this.descuento = getValorDeBoletos().multiply(BigDecimal.valueOf(DESCUENTO_MEMBRESIA_ESMERALDA));
            this.valorTotal = getValorDeBoletos().subtract(getDescuento());

        } else if (this.cliente.esMembresiaRuby()) {
            this.descuento = getValorDeBoletos().multiply(BigDecimal.valueOf(DESCUENTO_MEMBRESIA_RUBY));
            this.valorTotal = getValorDeBoletos().subtract(getDescuento());

        } else if (this.cliente.esMembresiaZafiro()) {
            this.descuento = getValorDeBoletos().multiply(BigDecimal.valueOf(DESCUENTO_MEMBRESIA_ZAFIRO));
            this.valorTotal = getValorDeBoletos().subtract(getDescuento());
        }
    }

    private void obtenerFecha(){
        this.fechaFactura = LocalDate.now();
    }

    public void anularFactura(){
        this.estadoFactura = EstadoFactura.ANULADA;
    }
    public void pagadoFactura(){
        this.estadoFactura = EstadoFactura.PAGADO;
    }
    private void aplicarDescuentoHappyDays(){
        //Encontrar la manera logica y correcta para extraer el datetime de los boletos sin que sean de diferente fecha en la lista de boletos.
        this.descuento = getValorDeBoletos().multiply(BigDecimal.valueOf(DESCUENTO_HAPPY_DAYS));
        this.valorTotal = getValorDeBoletos().subtract(getDescuento());
    }

    private void descuentosBoleto(){
        LocalDate fechaBoletos = this.boleto.obtenerFechaFuncion();
        DayOfWeek diaSemanaDeLaFuncion = fechaBoletos.getDayOfWeek();
        if(diaSemanaDeLaFuncion == DayOfWeek.TUESDAY || diaSemanaDeLaFuncion == DayOfWeek.WEDNESDAY ){
            aplicarDescuentoHappyDays();
        }
        else{
            aplicarDescuentoDeMembresia();
        }
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public EstadoFactura getEstadoFactura() {
        return estadoFactura;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorDeBoletos() {
        return valorDeBoletos;
    }

    public BigDecimal getDescuento() {

        return descuento;
    }


}
