export class Boleto{
  idBoleto?: number;
  cantidadAsientos: number;
  numeroAsientos: string;
  idFuncion: number;
}

export interface CreateBoletoDTO{
  cantidadAsientos: number;
  numeroAsientos: string;
  idFuncion: number;
}

export interface ValorBoletoReserva{
  valor: number;
}
