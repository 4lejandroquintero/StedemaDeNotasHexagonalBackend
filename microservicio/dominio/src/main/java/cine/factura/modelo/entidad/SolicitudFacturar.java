package cine.factura.modelo.entidad;


import cine.boleto.entidad.Boleto;
import cine.cliente.modelo.entidad.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SolicitudFacturar {
    private Cliente cliente;
    private Boleto boleto;
}
