package cine.factura.adaptador.dao;

import cine.factura.adaptador.repositorio.MapeoFactura;
import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.dao.DaoFactura;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class DaoFacturaMariaDB implements DaoFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFactura mapeoFactura;

    public DaoFacturaMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFactura mapeoFactura) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFactura = mapeoFactura;
    }

    @SqlStatement(namespace = "factura", value = "obtenerporid")
    private static String sqlObtenerPorId;


    @Override
    public Factura obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_factura", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoFactura));
    }
}
