package cine.pago.adaptador.dao;

import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import cine.pago.adaptador.repositorio.MapeoPago;
import cine.pago.entidad.Pago;
import cine.pago.entidad.dao.DaoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPagoMariaDB implements DaoPago {

    @Autowired
    private MapeoPago mapeoPago;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoPagoMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "pago", value = "obtenerporid")
    private static String sqlObtenerPorId;
    @Override
    public Pago obtenerPorID(Long idPago) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_pago", idPago);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoPago));
    }
}
