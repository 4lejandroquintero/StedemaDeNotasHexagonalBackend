package sistemaNotas.configuracion;

import sistemaNotas.categoria.puerto.CategoriaRepositorio;
import sistemaNotas.categoria.servicio.ServicioCrearCategoria;
import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.examen.servicio.ServicioCrearExamen;
import sistemaNotas.pregunta.puerto.PreguntaRepositorio;
import sistemaNotas.pregunta.servicio.ServicioCrearPregunta;
import sistemaNotas.usuario.puerto.UsuarioRepositorio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sistemaNotas.usuario.servicio.ServicioCrearUsuario;

@Configuration
public class BeanServicio {

    //endregion

    //region Usuario
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(UsuarioRepositorio usuarioRepositorio) {
        return new ServicioCrearUsuario(usuarioRepositorio);
    }

    //endregion

    //region Pregunta
    @Bean
    public ServicioCrearPregunta servicioCrearPregunta(PreguntaRepositorio preguntaRepositorio){
        return new ServicioCrearPregunta(preguntaRepositorio);
    }
    //endregion

    //region Examen
    @Bean
    public ServicioCrearExamen servicioCrearExamen(ExamenRepositorio examenRepositorio){
        return new ServicioCrearExamen(examenRepositorio);
    }

    //endregion

    //region Categoria
    @Bean
    public ServicioCrearCategoria servicioCrearCategoria(CategoriaRepositorio categoriaRepositorio){
        return new ServicioCrearCategoria(categoriaRepositorio);
    }
    //endregion

}
