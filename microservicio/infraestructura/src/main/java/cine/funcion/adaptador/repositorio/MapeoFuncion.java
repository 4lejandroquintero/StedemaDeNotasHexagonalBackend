package cine.funcion.adaptador.repositorio;

import cine.funcion.modelo.entidad.Funcion;
import cine.infraestructura.jdbc.MapperResult;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class MapeoFuncion implements RowMapper<Funcion>, MapperResult {
    private final RepositorioPelicula repositorioPelicula;

    public MapeoFuncion(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    @Override
    public Funcion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idFuncion = resultSet.getLong("id_funcion");
        Long idPelicula = resultSet.getLong("id_pelicula");
        String nombreTeatro = resultSet.getString("nombre_teatro_funcion");
        String salaFuncion = resultSet.getString("sala_funcion");
        LocalDate diaFuncion = resultSet.getDate("dia_funcion").toLocalDate();
        LocalTime horaFuncion = resultSet.getTime("hora_funcion").toLocalTime();
        BigDecimal valorFuncion = resultSet.getBigDecimal("valor_funcion");;
        String categoriaAudioFuncion = resultSet.getString("categoria_audio_funcion");;
        String categoriaSubtitulosFuncion = resultSet.getString("categoria_subtitulos_funcion");
        String categoriaVisualFuncion = resultSet.getString("categoria_dimension_visual_funcion");
        return Funcion.reconstruir(idFuncion, repositorioPelicula.obtener(idPelicula),nombreTeatro, salaFuncion, diaFuncion, horaFuncion,
                valorFuncion, categoriaAudioFuncion, categoriaSubtitulosFuncion, categoriaVisualFuncion);
    }
}
