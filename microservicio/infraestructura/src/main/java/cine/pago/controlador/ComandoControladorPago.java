package cine.pago.controlador;
import cine.ComandoRespuesta;
import cine.factura.comando.ComandoPagar;
import cine.factura.comando.manejador.ManejadorFacturaPagada;
import cine.pago.comando.ComandoRealizarPago;
import cine.pago.comando.manejador.ManejadorRealizarPago;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
@Tag(name = "Controlador comando de pago")
public class ComandoControladorPago {
    private final ManejadorRealizarPago manejadorRealizarPago;
    private final ManejadorFacturaPagada manejadorFacturaPagada;
    public ComandoControladorPago(ManejadorRealizarPago manejadorRealizarPago, ManejadorFacturaPagada manejadorFacturaPagada) {
        this.manejadorRealizarPago = manejadorRealizarPago;
        this.manejadorFacturaPagada = manejadorFacturaPagada;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Realizar Pago", description = "Metodo utilizado para pagar una factura")
    public ComandoRespuesta<Long> facturar(@RequestBody ComandoRealizarPago comandoRealizarPago) {
        this.manejadorFacturaPagada.ejecutar(new ComandoPagar(comandoRealizarPago.getIdFactura()));
        return this.manejadorRealizarPago.ejecutar(comandoRealizarPago);
    }


}
