package cine.pelicula.adaptador.repositorio;

import cine.infraestructura.jdbc.MapperResult;
import cine.pelicula.entidad.Pelicula;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPelicula implements RowMapper<Pelicula>, MapperResult {

    @Override
    public Pelicula mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idPelicula = resultSet.getLong("id");
        String nombrePelicula = resultSet.getString("nombre_pelicula");
        String sinopsisPelicula = resultSet.getString("sinopsis_pelicula");
        String imagenPortada = resultSet.getString("imagen_pelicula");
        String categoriaEdadPelicula = resultSet.getString("categoria_edad_pelicula");
        return Pelicula.reconstruir(idPelicula, nombrePelicula, sinopsisPelicula, imagenPortada, categoriaEdadPelicula);
    }
}
