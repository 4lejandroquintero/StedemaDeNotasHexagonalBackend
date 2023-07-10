package cine.pago.controlador;

import cine.factura.modelo.entidad.Factura;
import cine.pago.consulta.ManejadorConsultaPago;
import cine.pago.entidad.Pago;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
@Tag(name = "Controlador consulta de pago")
public class ConsultaControladorPago {
    private final ManejadorConsultaPago manejadorConsultaPago;

    public ConsultaControladorPago(ManejadorConsultaPago manejadorConsultaPago) {
        this.manejadorConsultaPago = manejadorConsultaPago;
    }
    @GetMapping("/{idBoleto}")
    @Operation(summary = "Obtener Pago", description = "Metodo utilizado para consultar pago por ID")
    public ResponseEntity<Pago> obtenerPorID(@PathVariable("idBoleto") Long id) {
        Pago pagoObtenido = manejadorConsultaPago.ejecutar(id);
        return new  ResponseEntity<>(pagoObtenido, HttpStatus.OK);
    }
}
