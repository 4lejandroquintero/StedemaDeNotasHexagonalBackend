// @ts-nocheck
function stryNS_9fa48() {
  var g = new Function("return this")();
  var ns = g.__stryker__ || (g.__stryker__ = {});
  if (ns.activeMutant === undefined && g.process && g.process.env && g.process.env.__STRYKER_ACTIVE_MUTANT__) {
    ns.activeMutant = g.process.env.__STRYKER_ACTIVE_MUTANT__;
  }
  function retrieveNS() {
    return ns;
  }
  stryNS_9fa48 = retrieveNS;
  return retrieveNS();
}
stryNS_9fa48();
function stryCov_9fa48() {
  var ns = stryNS_9fa48();
  var cov = ns.mutantCoverage || (ns.mutantCoverage = {
    static: {},
    perTest: {}
  });
  function cover() {
    var c = cov.static;
    if (ns.currentTestId) {
      c = cov.perTest[ns.currentTestId] = cov.perTest[ns.currentTestId] || {};
    }
    var a = arguments;
    for (var i = 0; i < a.length; i++) {
      c[a[i]] = (c[a[i]] || 0) + 1;
    }
  }
  stryCov_9fa48 = cover;
  cover.apply(null, arguments);
}
function stryMutAct_9fa48(id) {
  var ns = stryNS_9fa48();
  function isActive(id) {
    if (ns.activeMutant === id) {
      if (ns.hitCount !== void 0 && ++ns.hitCount > ns.hitLimit) {
        throw new Error('Stryker: Hit count limit reached (' + ns.hitCount + ')');
      }
      return true;
    }
    return false;
  }
  stryMutAct_9fa48 = isActive;
  return isActive(id);
}
import { faker } from '@faker-js/faker';
import { Funcion } from './funcion';
export const generateOneFuncion = (): Funcion => {
  if (stryMutAct_9fa48("363")) {
    {}
  } else {
    stryCov_9fa48("363");
    return stryMutAct_9fa48("364") ? {} : (stryCov_9fa48("364"), {
      idFuncion: faker.number.int(),
      nombreTeatro: faker.company.catchPhraseAdjective(),
      salaFuncion: faker.string.alphanumeric(2),
      diaFuncion: faker.date.soon().toDateString(),
      horaFuncion: faker.date.anytime().toString(),
      valorFuncion: parseInt(faker.commerce.price()),
      categoriaAudioFuncion: faker.music.genre(),
      categoriaSubtitulosFuncion: faker.string.fromCharacters(stryMutAct_9fa48("365") ? "" : (stryCov_9fa48("365"), 'espanol')),
      categoriaVisualFuncion: faker.string.fromCharacters(stryMutAct_9fa48("366") ? "" : (stryCov_9fa48("366"), 'espanol')),
      pelicula: stryMutAct_9fa48("367") ? {} : (stryCov_9fa48("367"), {
        idPelicula: faker.datatype.uuid(),
        nombrePelicula: faker.company.buzzAdjective(),
        imagenPortada: faker.image.avatar()
      })
    });
  }
};
export const generateManyFunciones = (size = 10): Funcion[] => {
  if (stryMutAct_9fa48("368")) {
    {}
  } else {
    stryCov_9fa48("368");
    const funciones: Funcion[] = stryMutAct_9fa48("369") ? ["Stryker was here"] : (stryCov_9fa48("369"), []);
    for (let index = 0; stryMutAct_9fa48("372") ? index >= size : stryMutAct_9fa48("371") ? index <= size : stryMutAct_9fa48("370") ? false : (stryCov_9fa48("370", "371", "372"), index < size); stryMutAct_9fa48("373") ? index-- : (stryCov_9fa48("373"), index++)) {
      if (stryMutAct_9fa48("374")) {
        {}
      } else {
        stryCov_9fa48("374");
        funciones.push(generateOneFuncion());
      }
    }
    return stryMutAct_9fa48("375") ? [] : (stryCov_9fa48("375"), [...funciones]);
  }
};