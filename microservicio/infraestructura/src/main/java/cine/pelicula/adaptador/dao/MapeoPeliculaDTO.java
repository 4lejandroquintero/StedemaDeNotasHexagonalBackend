package cine.pelicula.adaptador.dao;

import cine.infraestructura.jdbc.MapperResult;
import cine.pelicula.entidad.dto.PeliculaDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPeliculaDTO implements RowMapper<PeliculaDTO>, MapperResult {

    @Override
    public PeliculaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombrePelicula = resultSet.getString("nombre_pelicula");
        String sinopsisPelicula = resultSet.getString("sinopsis_pelicula");
        String imagenPortada = resultSet.getString("imagen_pelicula");
        String categoriaEdadPelicula = resultSet.getString("categoria_edad_pelicula");
        return new PeliculaDTO(id, nombrePelicula, sinopsisPelicula, imagenPortada, categoriaEdadPelicula);
    }
}
