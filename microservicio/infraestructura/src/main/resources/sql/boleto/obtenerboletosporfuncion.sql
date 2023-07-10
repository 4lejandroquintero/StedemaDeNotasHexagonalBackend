select  id_boleto, cantidad_asientos, numero_asientos_boleto, id_funcion
from boleto
where id_funcion = :id_funcion