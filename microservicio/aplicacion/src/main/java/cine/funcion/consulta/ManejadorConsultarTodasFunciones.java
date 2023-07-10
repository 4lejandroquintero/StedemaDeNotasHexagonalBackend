package cine.funcion.consulta;

import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.dao.DaoFuncion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarTodasFunciones {
    private final DaoFuncion daoFuncion;
    public ManejadorConsultarTodasFunciones(DaoFuncion daoFuncion) {
        this.daoFuncion = daoFuncion;
    }

    public List<Funcion> ejecutar(){
        return daoFuncion.obtenerTodasFunciones();
    }
}
