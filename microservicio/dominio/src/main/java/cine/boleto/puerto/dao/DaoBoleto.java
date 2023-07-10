package cine.boleto.puerto.dao;

import cine.boleto.entidad.Boleto;


import java.util.List;

public interface DaoBoleto {
    List<Boleto> obtenerBoletosDeFuncion(Long id);
    Boleto obtenerBoleto(Long id);
}
