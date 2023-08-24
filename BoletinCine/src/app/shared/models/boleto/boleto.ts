export interface Boleto{
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

export interface rtaBoletoReserva{
  valor: number;
}
