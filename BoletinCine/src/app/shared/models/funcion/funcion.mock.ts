import {faker} from '@faker-js/faker';
import {Funcion} from './funcion';

export const generateOneFuncion = (): Funcion => {
  return {
    idFuncion: faker.number.int(),
    pelicula: {
      idPelicula: faker.datatype.uuid(),
      nombrePelicula: faker.company.buzzAdjective(),
      imagenPortada: faker.image.avatar(),
    },
    nombreTeatro: faker.company.catchPhraseAdjective(),
    salaFuncion: faker.string.alphanumeric(2),
    diaFuncion: faker.date.soon().toDateString(),
    horaFuncion: faker.date.anytime().toString(),
    valorFuncion: parseInt(faker.commerce.price()),
    categoriaAudioFuncion: faker.music.genre(),
    categoriaSubtitulosFuncion: faker.string.fromCharacters('espanol'),
    categoriaVisualFuncion: faker.string.fromCharacters('espanol'),
  };
};

export const generateManyFunciones = (size = 10): Funcion[] => {
  const funciones: Funcion[] = [];
  for (let index = 0; index < size; index++) {
    funciones.push(generateOneFuncion());
  }
  return [... funciones];
}
