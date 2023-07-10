package cine.cliente.controlador;

import cine.ComandoRespuesta;
import cine.cliente.comando.ComandoSolicitudCrearCliente;
import cine.cliente.comando.manejador.ManejadorCrearCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador comando cliente")
public class ComandoControladorCliente{

    private final ManejadorCrearCliente manejadorCrearCliente;

    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear cliente", description = "Metodo para crear cliente nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearCliente comandoSolicitudCrearCliente){
        return this.manejadorCrearCliente.ejecutar(comandoSolicitudCrearCliente);
    }
}
