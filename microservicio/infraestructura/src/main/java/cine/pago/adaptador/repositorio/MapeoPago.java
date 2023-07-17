package cine.pago.adaptador.repositorio;

import cine.factura.puerto.repositorio.RepositorioFactura;
import cine.infraestructura.jdbc.MapperResult;
import cine.pago.entidad.Pago;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPago implements RowMapper<Pago>, MapperResult {
    private final RepositorioFactura repositorioFactura;

    public MapeoPago(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public Pago mapRow(ResultSet resultSet , int rowNum) throws SQLException {
        Long idPago = resultSet.getLong("id");
        Long idFactura = resultSet.getLong("id_factura");
        BigDecimal valorAPagar = resultSet.getBigDecimal("valor_a_pagar");
        BigDecimal devuelta = resultSet.getBigDecimal("devuelta");
        return Pago.reconstruir(idPago, repositorioFactura.obtener(idFactura),  valorAPagar, devuelta);
    }
}
