
export class BoletoDTO{
  idBoleto?: number;
  cantidadAsientos: number;
  numeroAsientos: string;
  idFuncion: number;
}

export interface FullBoleto{
  idBoleto: number;
  cantidadAsientos: number;
  numeroAsientos: string;
  funcion: {
    idFuncion: number;
    nombreTeatro: string;
    salaFuncion: string;
    diaFuncion: string;
    horaFuncion: string;
    valorFuncion: number;
    categoriaAudioFuncion: string;
    categoriaSubtitulosFuncion: string;
    categoriaVisualFuncion: string;
    pelicula: {
      idPelicula: string;
      nombrePelicula: string;
      imagenPortada: string;
    };
  };
}

export interface CreateBoletoDTO{
  cantidadAsientos: number;
  numeroAsientos: string;
  idFuncion: number;
}

export interface ValorBoletoReserva{
  valor: number;
}
