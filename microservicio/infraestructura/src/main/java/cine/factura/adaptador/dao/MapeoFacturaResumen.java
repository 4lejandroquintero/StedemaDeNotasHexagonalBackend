package cine.factura.adaptador.dao;

import cine.boleto.puerto.RepositorioBoleto;
import cine.cliente.puerto.RepositorioCliente;
import cine.cliente.puerto.dao.DaoCliente;
import cine.factura.modelo.dto.ResumenFacturaDTO;
import cine.factura.modelo.entidad.EstadoFactura;
import cine.factura.puerto.dao.DaoFactura;
import cine.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@Component
public class MapeoFacturaResumen implements RowMapper<ResumenFacturaDTO>, MapperResult {
    private final RepositorioBoleto repositorioBoleto;

    private final DaoCliente daoCliente;

    public MapeoFacturaResumen(RepositorioBoleto repositorioBoleto, DaoCliente daoCliente) {
        this.repositorioBoleto = repositorioBoleto;
        this.daoCliente = daoCliente;
    }
    @Override
    public ResumenFacturaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idFactura = resultSet.getLong("id_factura");
        Long idBoleto = resultSet.getLong("id_boleto");
        Long idCliente = resultSet.getLong("id_cliente");
        LocalDate fechaFactura = resultSet.getDate("fecha_factura").toLocalDate();
        EstadoFactura estadoFactura = EstadoFactura.valueOf(resultSet.getString("estado_factura"));
        BigDecimal valorDeBoletos = resultSet.getBigDecimal("valor_boletos_factura");
        BigDecimal descuento = resultSet.getBigDecimal("valor_descuento_factura");
        BigDecimal valorTotal = resultSet.getBigDecimal("valor_total");
        return new ResumenFacturaDTO(idFactura, repositorioBoleto.obtener(idBoleto),daoCliente.obtenerDatosClientePorID(idCliente).orElseThrow(()-> new NoSuchElementException("Cliente no encontrado")),
                fechaFactura, estadoFactura, valorDeBoletos,descuento, valorTotal);
    }
}
