package cine.boleto.adaptador.dao;

import cine.boleto.adaptador.repositorio.MapeoBoleto;
import cine.boleto.entidad.Boleto;
import cine.boleto.puerto.dao.DaoBoleto;
import cine.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import cine.infraestructura.jdbc.EjecucionBaseDeDatos;
import cine.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoBoletoMariaDB implements DaoBoleto {
    @Override
    public List<Boleto> obtenerBoletosDeFuncion(Long id) {
        return null;
    }

    @Override
    public Boleto obtenerBoleto(Long id) {
        return null;
    }
    /*private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoBoleto mapeoBoleto;

    public DaoBoletoMariaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoBoleto mapeoBoleto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoBoleto = mapeoBoleto;
    }
    //region SQLSTATEMENTS
    @SqlStatement(namespace = "boleto", value = "obtenerboletosporfuncion")
    private static String sqlObtenerBoletosPorFuncion;
    @SqlStatement(namespace = "boleto", value = "obtenerporid")
    private static String sqlObtenerBoleto;
    //endregion

    @Override
    public List<Boleto> obtenerBoletosDeFuncion(Long idFuncion) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_funcion", idFuncion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerBoletosPorFuncion, parameterSource, mapeoBoleto);
    }

    @Override
    public Boleto obtenerBoleto(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_boleto", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerBoleto, parameterSource, mapeoBoleto));
    }*/
}
