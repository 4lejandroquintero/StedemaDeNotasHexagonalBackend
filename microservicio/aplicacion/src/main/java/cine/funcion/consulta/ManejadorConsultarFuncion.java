package cine.funcion.consulta;

import cine.funcion.modelo.entidad.Funcion;
import cine.funcion.puerto.dao.DaoFuncion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarFuncion {
    private final DaoFuncion daoFuncion;
    public ManejadorConsultarFuncion(DaoFuncion daoFuncion) {
        this.daoFuncion = daoFuncion;
    }

    public Funcion ejecutar(Long id){
        return daoFuncion.obtenerFuncion(id);
    }
}
