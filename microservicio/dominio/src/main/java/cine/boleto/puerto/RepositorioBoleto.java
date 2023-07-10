package cine.boleto.puerto;

import cine.boleto.entidad.Boleto;

public interface RepositorioBoleto {
    Long crear(Boleto boleto);
    Boleto obtener(Long id);
    boolean existe (Long id);
}
