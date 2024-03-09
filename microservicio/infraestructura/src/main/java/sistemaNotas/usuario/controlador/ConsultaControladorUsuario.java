package sistemaNotas.usuario.controlador;


import sistemaNotas.ComandoRespuesta;
import sistemaNotas.usuario.comando.ComandoAutenticacion;
import sistemaNotas.configuracion.JwtService;
import sistemaNotas.configuracion.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sistemaNotas.usuario.consulta.ManejadorConsultarUsuarios;
import sistemaNotas.usuario.consulta.ManejadorObtenerUsuario;
import sistemaNotas.usuario.modelo.dto.UsuarioAutenticadoDatos;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosCompletos;
import sistemaNotas.usuario.modelo.dto.UsuarioDatosPrincipalesDTO;
import sistemaNotas.usuario.modelo.entidad.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Controlador consulta usuario")
public class ConsultaControladorUsuario {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    private final ManejadorConsultarUsuarios manejadorConsultarUsuarios;
    private final JwtService jwtService;

  public ConsultaControladorUsuario(ManejadorObtenerUsuario manejadorObtenerUsuario, ManejadorConsultarUsuarios manejadorConsultarUsuarios, JwtService jwtService) {
    this.manejadorObtenerUsuario = manejadorObtenerUsuario;
    this.manejadorConsultarUsuarios = manejadorConsultarUsuarios;
    this.jwtService = jwtService;
  }


  @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los usuarios")
    public List<UsuarioDatosPrincipalesDTO> obtenerUsuarios(){
        return manejadorConsultarUsuarios.ejecutar();
    }
    @GetMapping("/{id}")
    public UsuarioDatosPrincipalesDTO obtenerUsuario(@PathVariable("id") Long id){
        return manejadorObtenerUsuario.ejecutar(id);
    }

    @GetMapping("/full/{id}")
    public UsuarioDatosCompletos obtenerFullUsuario(@PathVariable("id") Long id){
        return manejadorObtenerUsuario.obtener(id);
    }

    @PostMapping("/login")
    public ComandoRespuesta<UsuarioAutenticadoDatos> login(@RequestBody ComandoAutenticacion comandoAutenticacion){
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(comandoAutenticacion.getUsername(),
                        comandoAutenticacion.getPassword()));

        Usuario usuario = (Usuario) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(usuario);
        UsuarioAutenticadoDatos response = new UsuarioAutenticadoDatos(accessToken,
          usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido(),
          usuario.getEmail(), usuario.getTelefono(), usuario.isEnabled(),
          usuario.getRol().toString());
        return new ComandoRespuesta<>(response);
    }




}
