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
import { Factura } from './factura';
import { generarAsientos } from '../../../feature/website/boleto/asientos/totalasientos';
enum estadosFactura {
  PENDIENTE,
  PAGADO,
}
export const generateOneFactura = (): Factura => {
  if (stryMutAct_9fa48("355")) {
    {}
  } else {
    stryCov_9fa48("355");
    return stryMutAct_9fa48("356") ? {} : (stryCov_9fa48("356"), {
      idFactura: faker.number.int(100),
      fechaFactura: faker.date.anytime().toLocaleDateString(),
      estadoFactura: faker.helpers.enumValue(estadosFactura).toString(),
      valorDeBoletos: parseInt(faker.commerce.price()),
      descuento: parseInt(faker.commerce.price()),
      valorTotal: parseInt(faker.commerce.price()),
      cliente: stryMutAct_9fa48("357") ? {} : (stryCov_9fa48("357"), {
        nombre: faker.person.firstName(),
        documentoIdentidad: faker.person.zodiacSign()
      }),
      boleto: stryMutAct_9fa48("358") ? {} : (stryCov_9fa48("358"), {
        idBoleto: faker.number.int(100),
        cantidadAsientos: faker.number.int(56),
        numeroAsientos: faker.helpers.arrayElements(generarAsientos()).toString(),
        funcion: stryMutAct_9fa48("359") ? {} : (stryCov_9fa48("359"), {
          salaFuncion: faker.string.alphanumeric(2),
          diaFuncion: faker.date.soon().toDateString(),
          horaFuncion: faker.date.anytime().toString(),
          categoriaAudioFuncion: faker.music.genre(),
          categoriaSubtitulosFuncion: faker.string.fromCharacters(stryMutAct_9fa48("360") ? "" : (stryCov_9fa48("360"), 'espanol')),
          categoriaVisualFuncion: faker.string.fromCharacters(stryMutAct_9fa48("361") ? "" : (stryCov_9fa48("361"), 'espanol')),
          pelicula: stryMutAct_9fa48("362") ? {} : (stryCov_9fa48("362"), {
            nombrePelicula: faker.animal.bear(),
            sinopsisPelicula: faker.word.adjective(),
            imagenPortada: faker.image.avatar(),
            categoriaEdadPelicula: faker.string.alphanumeric(2)
          })
        })
      })
    });
  }
};