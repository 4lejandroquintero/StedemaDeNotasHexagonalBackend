package cine.pago.adaptador.repositorio;

import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import cine.pago.entidad.Pago;
import cine.pago.puerto.RepositorioPago;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagoMariaDB implements RepositorioPago {

    private final MapeoPago mapeoPago;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    public RepositorioPagoMariaDB(MapeoPago mapeoPago, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.mapeoPago = mapeoPago;
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "pago", value = "crear")
    private static String sqlCrear;
    @SqlStatement(namespace = "pago", value = "obtenerporid")
    private static String sqlObtenerPorId;

    @Override
    public Long crear(Pago pago) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_factura", pago.getFactura().getIdFactura());
        paramSource.addValue("valor_a_pagar", pago.getValorAPagar());
        paramSource.addValue("devuelta", pago.getDevuelta());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Pago obtener(Long idPago) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPago);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoPago));
    }
}
