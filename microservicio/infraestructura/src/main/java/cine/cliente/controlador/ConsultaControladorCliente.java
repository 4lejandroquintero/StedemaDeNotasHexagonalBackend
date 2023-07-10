package cine.cliente.controlador;


import cine.cliente.consulta.ManejadorConsultarClientes;
import cine.cliente.consulta.ManejadorObtenerCliente;
import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador consulta cliente")
public class ConsultaControladorCliente {

    private final ManejadorObtenerCliente manejadorObtenerCliente;

    private final ManejadorConsultarClientes manejadorConsultarClientes;

    public ConsultaControladorCliente(ManejadorObtenerCliente manejadorObtenerCliente, ManejadorConsultarClientes manejadorConsultarClientes) {
        this.manejadorObtenerCliente = manejadorObtenerCliente;
        this.manejadorConsultarClientes = manejadorConsultarClientes;
    }

    @GetMapping("/all")
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los clientes")
    public List<ClienteDatosPrincipalesDTO> obtenerClientes(){
        return manejadorConsultarClientes.ejecutar();
    }
    @GetMapping("/{id}")
    public ClienteDatosPrincipalesDTO obtenerCliente(@PathVariable("id") Long id){
        return manejadorObtenerCliente.ejecutar(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
