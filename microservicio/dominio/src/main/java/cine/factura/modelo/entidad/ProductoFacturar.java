package cine.factura.modelo.entidad;

import cine.boleto.entidad.Boleto;

public class ProductoFacturar {
    public static final Double VALOR_IVA = 0.19;

    private Long idFactura;
    private Integer cantidad;
    private Boleto boleto;
}
