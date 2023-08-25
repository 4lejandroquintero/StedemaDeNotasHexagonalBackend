
import { faker } from '@faker-js/faker';
import { FullBoleto } from './boleto';
import { generarAsientos } from '../../../feature/website/boleto/asientos/totalasientos';
import { generateOneFuncion } from '../funcion/funcion.mock';

export const generateOneBoleto = (): FullBoleto => {
  return {
    idBoleto: faker.number.int(100),
    cantidadAsientos: faker.number.int(56),
    numeroAsientos: faker.helpers.arrayElements(generarAsientos()).toString(),
    funcion: generateOneFuncion(),
  };
};
