package cine.boleto.adaptador.repositorio;

import cine.boleto.entidad.Boleto;
import cine.funcion.puerto.RepositorioFuncion;
import cine.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoBoleto implements RowMapper<Boleto>, MapperResult {
    private final RepositorioFuncion repositorioFuncion;

    public MapeoBoleto(RepositorioFuncion repositorioFuncion) {
        this.repositorioFuncion = repositorioFuncion;
    }


    @Override
    public Boleto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idBoleto = resultSet.getLong("id_boleto");
        Integer cantidadAsientos = resultSet.getInt("cantidad_asientos");
        String numeroAsiento = resultSet.getString("numero_asientos_boleto");
        Long idFuncion= resultSet.getLong("id_funcion");
        return Boleto.reconstruir(idBoleto,cantidadAsientos, numeroAsiento, repositorioFuncion.obtener(idFuncion));
    }
}
