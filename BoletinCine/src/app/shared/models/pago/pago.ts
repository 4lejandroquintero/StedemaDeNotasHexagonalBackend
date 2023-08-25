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
  factura: {
    idFactura: number;
    fechaFactura: string;
    estadoFactura: string;
    valorDeBoletos: number;
    descuento: number;
    valorTotal: number;
    cliente: {
      nombre: string;
      documentoIdentidad: string;
    };
    boleto: {
      idBoleto: number;
      cantidadAsientos: number;
      numeroAsientos: string;
      funcion: {
        salaFuncion: string;
        diaFuncion: string;
        horaFuncion: string;
        categoriaAudioFuncion: string;
        categoriaSubtitulosFuncion: string;
        categoriaVisualFuncion: string;
        pelicula: {
          nombrePelicula: string;
          sinopsisPelicula: string;
          imagenPortada: string;
          categoriaEdadPelicula: string;
        };
      };
    };
  };
}
