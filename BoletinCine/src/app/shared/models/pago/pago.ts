import { Factura } from '@models/factura/factura';
export class PagoDTO{
  idFactura: number;
  valorAPagar: number;
}


export interface ValorRetornoPago{
  valor: number;
}

export interface Pago{
  valorAPagar: number;
  devuelta: number;
  factura: Factura;
}
