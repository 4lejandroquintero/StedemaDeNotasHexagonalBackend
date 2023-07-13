package cine.factura.adaptador.repositorio;

import cine.boleto.puerto.RepositorioBoleto;
import cine.cliente.puerto.RepositorioCliente;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.modelo.entidad.Factura;
import cine.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class MapeoFactura implements RowMapper<Factura>, MapperResult {
    private final RepositorioBoleto repositorioBoleto;
    private final RepositorioCliente repositorioCliente;

    public MapeoFactura(RepositorioBoleto repositorioBoleto, RepositorioCliente repositorioCliente) {
        this.repositorioBoleto = repositorioBoleto;
        this.repositorioCliente = repositorioCliente;
    }

    @Override
    public Factura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idFactura = resultSet.getLong("id_factura");
        Long idBoleto = resultSet.getLong("id_boleto");
        Long idCliente = resultSet.getLong("id_cliente");
        LocalDate fechaFactura = resultSet.getDate("fecha_factura").toLocalDate();
        EstadoFactura estadoFactura = EstadoFactura.valueOf(resultSet.getString("estado_factura"));
        BigDecimal valorDeBoletos = resultSet.getBigDecimal("valor_boletos_factura");
        BigDecimal descuento = resultSet.getBigDecimal("valor_descuento_factura");
        BigDecimal valorTotal = resultSet.getBigDecimal("valor_total");
        return Factura.reconstruir(idFactura, repositorioBoleto.obtener(idBoleto),repositorioCliente.obtener(idCliente),
                fechaFactura, estadoFactura, valorDeBoletos,descuento, valorTotal);
    }
}
