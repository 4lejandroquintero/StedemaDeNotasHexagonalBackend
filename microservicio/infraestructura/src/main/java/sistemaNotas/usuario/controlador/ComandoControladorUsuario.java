package sistemaNotas.usuario.controlador;

import sistemaNotas.ComandoRespuesta;
import sistemaNotas.usuario.comando.ComandoSolicitudCrearUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistemaNotas.usuario.comando.manejador.ManejadorCrearUsuario;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Controlador comando usuario")
public class ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;

  public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario) {
    this.manejadorCrearUsuario = manejadorCrearUsuario;
  }


  @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear usuario", description = "Metodo para crear usuario nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario){
        return this.manejadorCrearUsuario.ejecutar(comandoSolicitudCrearUsuario);
    }
}
