package sistemaNotas.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import sistemaNotas.usuario.puerto.UsuarioRepositorio;

@Service
public class JwtService {

    private final AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    private final UsuarioRepositorio usuarioRepositorio;
    public JwtService(AuthenticationManager authManager, UsuarioRepositorio usuarioRepositorio) {
        this.authManager = authManager;
        this.usuarioRepositorio = usuarioRepositorio;
    }


}
