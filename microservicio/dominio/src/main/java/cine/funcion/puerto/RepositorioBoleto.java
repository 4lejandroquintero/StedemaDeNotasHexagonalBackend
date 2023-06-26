package cine.funcion.puerto;

import cine.boleto.entidad.Boleto;

public interface RepositorioBoleto {
    Boleto obtener(Long id);
}
