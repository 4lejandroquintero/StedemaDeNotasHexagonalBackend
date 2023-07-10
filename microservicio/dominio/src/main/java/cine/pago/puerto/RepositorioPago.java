package cine.pago.puerto;

import cine.pago.entidad.Pago;

public interface RepositorioPago {
    Long crear(Pago pago);
    Pago obtener(Long id);
}
