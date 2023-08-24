export interface Boleto{
  idBoleto?: number;
  cantidadAsientos: number;
  numeroAsientos: string;
  idFuncion: number;
}

export type CreateBoletoDTO = Omit<Boleto, 'idBoleto'>;
