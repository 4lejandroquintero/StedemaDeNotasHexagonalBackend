import {  faker } from '@faker-js/faker';
import { Factura } from './factura';
import { generarAsientos } from '../../../feature/website/boleto/asientos/totalasientos';
enum estadosFactura {
  PENDIENTE, PAGADO
}

export const generateOneFactura = (): Factura => {
  return {
    idFactura: faker.number.int(100),
    fechaFactura: faker.date.anytime().toLocaleDateString(),
    estadoFactura: faker.helpers.enumValue(estadosFactura).toString(),
    valorDeBoletos: parseInt(faker.commerce.price()),
    descuento: parseInt(faker.commerce.price()),
    valorTotal: parseInt(faker.commerce.price()),
    cliente: {
      nombre: faker.person.firstName(),
      documentoIdentidad: faker.person.zodiacSign(),
    },
    boleto: {
      idBoleto: faker.number.int(100),
      cantidadAsientos: faker.number.int(56),
      numeroAsientos: faker.helpers.arrayElements(generarAsientos()).toString(),
      funcion: {
        salaFuncion: faker.string.alphanumeric(2),
        diaFuncion: faker.date.soon().toDateString(),
        horaFuncion: faker.date.anytime().toString(),
        categoriaAudioFuncion: faker.music.genre(),
        categoriaSubtitulosFuncion: faker.string.fromCharacters('espanol'),
        categoriaVisualFuncion: faker.string.fromCharacters('espanol'),
        pelicula: {
          nombrePelicula: faker.animal.bear(),
          sinopsisPelicula: faker.word.adjective(),
          imagenPortada: faker.image.avatar(),
          categoriaEdadPelicula: faker.string.alphanumeric(2)
        },
      },
    },
  };
};
