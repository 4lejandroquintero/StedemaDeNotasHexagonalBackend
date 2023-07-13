package cine.factura.controlador;
import cine.ComandoRespuesta;
import cine.factura.comando.ComandoSolicitudFacturar;
import cine.factura.comando.manejador.ManejadorFacturar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador comando de factura")
public class ComandoControladorFactura {
    private final ManejadorFacturar manejadorFacturar;
    public ComandoControladorFactura(ManejadorFacturar manejadorFacturar) {
        this.manejadorFacturar = manejadorFacturar;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Facturar", description = "Metodo utilizado para crear una nueva factura")
    public ComandoRespuesta<Long> facturar(@RequestBody ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return this.manejadorFacturar.ejecutar(comandoSolicitudFacturar);
    }




}
