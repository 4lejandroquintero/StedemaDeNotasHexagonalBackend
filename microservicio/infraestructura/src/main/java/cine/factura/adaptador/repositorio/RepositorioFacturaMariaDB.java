package cine.factura.adaptador.repositorio;

import cine.factura.modelo.entidad.Factura;
import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFacturaMariaDB implements RepositorioFactura {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFactura mapeoFactura;

    public RepositorioFacturaMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFactura mapeoFactura) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFactura = mapeoFactura;
    }
    @SqlStatement(namespace = "factura", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "factura", value = "obtenerporid")
    private static String sqlObtenerPorId;

    @SqlStatement(namespace = "factura", value = "actualizarestado")
    private static String sqlActualizarEstado;

    @Override
    public Long guardar(Factura factura) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_factura", factura.getIdFactura());
        parameterSource.addValue("id_boleto", factura.getBoleto().getIdBoleto());
        parameterSource.addValue("id_cliente", factura.getCliente().getIdCliente());
        parameterSource.addValue("fecha_factura", factura.getFechaFactura());
        parameterSource.addValue("estado_factura", factura.getEstadoFactura().name());
        parameterSource.addValue("valor_boletos_factura", factura.getValorDeBoletos());
        parameterSource.addValue("valor_descuento_factura", factura.getDescuento());
        parameterSource.addValue("valor_total", factura.getValorTotal());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource,sqlCrear);
    }

    @Override
    public Factura obtener(Long idFactura) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_factura", idFactura);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoFactura));
    }

    @Override
    public void actualizarEstado(Factura factura) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_factura", factura.getIdFactura());
        parameterSource.addValue("estado_factura", factura.getEstadoFactura().toString());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEstado, parameterSource);

    }
}
