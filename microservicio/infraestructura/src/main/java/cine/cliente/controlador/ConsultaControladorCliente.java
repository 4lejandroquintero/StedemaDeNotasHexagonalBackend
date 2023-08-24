package cine.cliente.controlador;


import cine.ComandoRespuesta;
import cine.cliente.comando.ComandoAutenticacion;
import cine.cliente.consulta.ManejadorConsultarClientes;
import cine.cliente.consulta.ManejadorObtenerCliente;
import cine.cliente.modelo.dto.ClienteAutenticadoDatos;
import cine.cliente.modelo.dto.ClienteDatosCompletos;
import cine.cliente.modelo.dto.ClienteDatosPrincipalesDTO;
import cine.cliente.modelo.entidad.Cliente;
import cine.configuracion.JwtService;
import cine.configuracion.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador consulta cliente")
public class ConsultaControladorCliente {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    private final ManejadorObtenerCliente manejadorObtenerCliente;

    private final ManejadorConsultarClientes manejadorConsultarClientes;
    private final JwtService jwtService;

    public ConsultaControladorCliente(ManejadorObtenerCliente manejadorObtenerCliente, ManejadorConsultarClientes manejadorConsultarClientes, JwtService jwtService) {
        this.manejadorObtenerCliente = manejadorObtenerCliente;
        this.manejadorConsultarClientes = manejadorConsultarClientes;
        this.jwtService = jwtService;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los clientes")
    public List<ClienteDatosPrincipalesDTO> obtenerClientes(){
        return manejadorConsultarClientes.ejecutar();
    }
    @GetMapping("/{id}")
    public ClienteDatosPrincipalesDTO obtenerCliente(@PathVariable("id") Long id){
        return manejadorObtenerCliente.ejecutar(id);
    }

    @GetMapping("/full/{id}")
    public ClienteDatosCompletos obtenerFullCliente(@PathVariable("id") Long id){
        return manejadorObtenerCliente.obtener(id);
    }

    @PostMapping("/login")
    public ComandoRespuesta<ClienteAutenticadoDatos> login(@RequestBody ComandoAutenticacion comandoAutenticacion){
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(comandoAutenticacion.getCorreo(),
                        comandoAutenticacion.getContrasena()));

        Cliente cliente = (Cliente) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(cliente);
        ClienteAutenticadoDatos response = new ClienteAutenticadoDatos(accessToken, cliente.getIdCliente(),
                cliente.getNombre(), cliente.getEmail(), cliente.getContrasena(), cliente.getDocumentoIdentidad(),
                cliente.getTipoMembresia().toString());
        return new ComandoRespuesta<>(response);
    }

    


}
