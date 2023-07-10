package cine.boleto.controlador;

import cine.ComandoRespuesta;
import cine.boleto.comando.ComandoSolicitudCrearBoleto;
import cine.boleto.comando.manejador.ManejadorCrearBoleto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boleto")
@Tag(name = "Controlador comando de boletos")
public class ComandoControladorBoleto {
    private final ManejadorCrearBoleto manejadorCrearBoleto;

    public ComandoControladorBoleto(ManejadorCrearBoleto manejadorCrearBoleto) {
        this.manejadorCrearBoleto = manejadorCrearBoleto;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear Boleto", description = "Metodo utilizado para crear una funcion")
    public ComandoRespuesta<Long> crearFuncion(@RequestBody ComandoSolicitudCrearBoleto comandoSolicitudCrearBoleto){
        return this.manejadorCrearBoleto.ejecutar(comandoSolicitudCrearBoleto);
    }

}
