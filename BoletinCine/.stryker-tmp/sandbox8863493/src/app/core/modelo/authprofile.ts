// @ts-nocheck
export interface Auth {
  valor: {
    token: string;
    idCliente: number;
    nombre: string;
    email: string;
    contrasena: string;
    documentoIdentidad: string;
    tipoMembresia: string;
  };
}