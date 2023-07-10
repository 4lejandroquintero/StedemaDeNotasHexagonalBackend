select  id_factura ,id_boleto, id_cliente, fecha_factura, estado_factura, valor_boletos_factura,valor_descuento_factura, valor_total
from factura
where id_factura = :id_factura