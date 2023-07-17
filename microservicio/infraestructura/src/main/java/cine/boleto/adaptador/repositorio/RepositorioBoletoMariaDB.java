package cine.boleto.adaptador.repositorio;

import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.RepositorioBoleto;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioBoletoMariaDB implements RepositorioBoleto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoBoleto mapeoBoleto;

    public RepositorioBoletoMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoBoleto mapeoBoleto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoBoleto = mapeoBoleto;
    }

    @SqlStatement(namespace = "boleto",value = "crearboleto")
    private static String sqlCrearBoleto;
    @SqlStatement(namespace = "boleto",value = "obtenerporid")
    private static String sqlObtenerPorID;

    @Override
    public Long crear(Boleto boleto) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", boleto.getIdBoleto());
        parameterSource.addValue("cantidad_asientos", boleto.getCantidadAsientos());
        parameterSource.addValue("numero_asientos_boleto", boleto.getNumeroAsientos());
        parameterSource.addValue("id_funcion", boleto.getFuncion().getIdFuncion());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearBoleto);
    }

    @Override
    public Boleto obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoBoleto));
    }

    @Override
    public boolean existe(Long id) {
        return false;
    }
}
