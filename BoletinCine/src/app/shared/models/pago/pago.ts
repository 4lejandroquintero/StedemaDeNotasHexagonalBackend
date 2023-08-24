export interface Pago{
  idFactura: number;
  valorAPagar: number;
}


export interface IdPago{
  valor: number;
}

export interface PagoDTO{
  factura: {
    boleto: {
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
        };
      };
    };
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
  };
  valorAPagar: number;
  devuelta: number;
}
