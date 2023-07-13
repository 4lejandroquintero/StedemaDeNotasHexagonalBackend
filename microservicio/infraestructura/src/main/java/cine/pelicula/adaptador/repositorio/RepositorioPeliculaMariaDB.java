package cine.pelicula.adaptador.repositorio;

import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import cine.pelicula.entidad.Pelicula;
import cine.pelicula.puerto.RepositorioPelicula;
import cine.pelicula.servicio.ServicioCrearPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPeliculaMariaDB implements RepositorioPelicula {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @Autowired
    private final MapeoPelicula mapeoPelicula;

    public RepositorioPeliculaMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPelicula mapeoPelicula) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPelicula = mapeoPelicula;
    }

    @SqlStatement(namespace = "pelicula", value = "obtenerpornombre")
    private static String sqlObtenerPorNombre;
    @SqlStatement(namespace = "pelicula", value = "crearpelicula")
    private static String sqlCrearPelicula;

    @SqlStatement(namespace = "pelicula", value = "obtenerporid")
    private static String sqlObtenerPeliculaPorID;


    @Override
    public Long crear(Pelicula pelicula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", pelicula.getIdPelicula());
        parameterSource.addValue("nombre_pelicula", pelicula.getNombrePelicula());
        parameterSource.addValue("sinopsis_pelicula", pelicula.getSinopsisPelicula());
        parameterSource.addValue("imagen_pelicula", pelicula.getImagenPortada());
        parameterSource.addValue("categoria_edad_pelicula", pelicula.getCategoriaEdadPelicula());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource,sqlCrearPelicula);
    }

    @Override
    public Pelicula obtener(Long idPelicula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", idPelicula);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPeliculaPorID, parameterSource, mapeoPelicula));
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(Long id) {
        return false;
    }
}
