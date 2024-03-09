package sistemaNotas.categoria.adaptador.repositorio;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.examen.puerto.ExamenRepositorio;
import sistemaNotas.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoCategoria implements RowMapper<Categoria>, MapperResult {
    private final ExamenRepositorio examenRepositorio;

    public MapeoCategoria(ExamenRepositorio examenRepositorio) {
        this.examenRepositorio = examenRepositorio;
    }


    @Override
    public Categoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idCategoria = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        String descripcion = resultSet.getString("descripcion");
        Long idExamen= resultSet.getLong("id_examen");
        return Categoria.reconstruir(idCategoria,titulo, descripcion, examenRepositorio.obtener(idExamen));
    }
}
