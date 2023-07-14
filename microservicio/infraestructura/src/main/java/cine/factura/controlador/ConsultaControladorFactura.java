package cine.factura.controlador;

import cine.factura.consulta.ManejadorConsultaFactura;
import cine.factura.modelo.dto.ResumenFacturaDTO;
import cine.factura.modelo.entidad.Factura;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador consulta de factura")
public class ConsultaControladorFactura {
    private final ManejadorConsultaFactura manejadorConsultaFactura;

    public ConsultaControladorFactura(ManejadorConsultaFactura manejadorConsultaFactura) {
        this.manejadorConsultaFactura = manejadorConsultaFactura;
    }

    @GetMapping("/{idFactura}")
    @Operation(summary = "Obtener Factura", description = "Metodo utilizado para consultar factura por ID")
    public ResponseEntity<ResumenFacturaDTO> obtenerPorID(@PathVariable("idFactura") Long id) {
        ResumenFacturaDTO facturaObtenida = manejadorConsultaFactura.obtenerFactura(id);
        return new  ResponseEntity<>(facturaObtenida, HttpStatus.OK);
    }
}
