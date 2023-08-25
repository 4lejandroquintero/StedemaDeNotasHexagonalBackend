export class Factura {
  idCliente: number;
  idBoleto: number;
}

export interface FacturaDTO{
  idFactura: number;
  fechaFactura: string;
  estadoFactura: string;
  valorDeBoletos: number;
  descuento: number;
  valorTotal: number;
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
        sinopsisPelicula: string;
        imagenPortada: string;
        categoriaEdadPelicula: string;
      };
    };

  };

}
