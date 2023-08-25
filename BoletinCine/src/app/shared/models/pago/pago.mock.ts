import { generateOneFactura } from '@shared/models/factura/factura.mock';
import { faker } from '@faker-js/faker';

export const generateOnePago = (): InfoPagoMock =>{
  return {
    valorAPagar: faker.number.int(50000),
    devuelta: faker.number.int(50000),
    factura: generateOneFactura()
  };
};
interface InfoPagoMock {
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
