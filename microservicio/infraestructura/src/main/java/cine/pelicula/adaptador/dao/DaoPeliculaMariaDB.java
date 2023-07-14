package cine.pelicula.adaptador.dao;

import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import cine.pelicula.adaptador.repositorio.MapeoPelicula;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.entidad.dto.PeliculaDTO;
import cine.pelicula.puerto.dao.DaoPelicula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DaoPeliculaMariaDB implements DaoPelicula {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoPeliculaDTO mapeoPeliculaDTO;
    public DaoPeliculaMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPeliculaDTO mapeoPeliculaDTO) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPeliculaDTO = mapeoPeliculaDTO;
    }

    //SQLSTATEMENTS
    @SqlStatement(namespace = "pelicula", value = "obtenerporid")
    private static String sqlObtenerPeliculaPorID;

    @SqlStatement(namespace = "pelicula", value = "obtenerpeliculas")
    private static String sqlObtenerTodasLasPeliculas;

    @Override
    public List<PeliculaDTO> obtenerTodasPeliculas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodasLasPeliculas, mapeoPeliculaDTO);
    }

    @Override
    public Pelicula obtenerPeliculaPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPeliculaPorID,
                parameterSource, new MapeoPelicula()));
    }
}
