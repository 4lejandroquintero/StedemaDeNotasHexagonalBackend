package cine.configuracion;


import cine.cliente.puerto.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    private final RepositorioCliente repositorioCliente;
    public JwtService(AuthenticationManager authManager, RepositorioCliente repositorioCliente) {
        this.authManager = authManager;
        this.repositorioCliente = repositorioCliente;
    }


}
