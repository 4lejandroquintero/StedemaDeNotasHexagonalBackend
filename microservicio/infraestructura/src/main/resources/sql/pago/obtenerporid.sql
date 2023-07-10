select  id_pago, id_factura, valor_a_pagar, devuelta
from pago
where id_pago = :id_pago