package cine.pago.controlador;
import cine.ComandoRespuesta;
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
    public ComandoControladorPago(ManejadorRealizarPago manejadorRealizarPago) {
        this.manejadorRealizarPago = manejadorRealizarPago;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Realizar Pago", description = "Metodo utilizado para pagar una factura")
    public ComandoRespuesta<Long> facturar(@RequestBody ComandoRealizarPago comandoRealizarPago) {
        return this.manejadorRealizarPago.ejecutar(comandoRealizarPago);
    }


}
