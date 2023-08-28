// @ts-nocheck
export interface Cliente {
  id?: number;
  nombre: string;
  email: string;
  contrasena?: string;
  documentoIdentidad: string;
  tipoMembresia: string;
}
export enum Membresia {
  RUBY,
  ZAFIRO,
  ESMERALDA,
}